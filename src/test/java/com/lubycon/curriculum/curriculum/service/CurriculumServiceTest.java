package com.lubycon.curriculum.curriculum.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.lubycon.curriculum.blog.domain.Blog;
import com.lubycon.curriculum.curriculum.domain.Curriculum;
import com.lubycon.curriculum.curriculum.dto.CurriculumInfoResponse;
import com.lubycon.curriculum.curriculum.dto.CurriculumResponse;
import com.lubycon.curriculum.curriculum.dto.SaveBlog;
import com.lubycon.curriculum.curriculum.dto.SaveCurriculums;
import com.lubycon.curriculum.curriculum.dto.SaveSections;
import com.lubycon.curriculum.curriculum.dto.SectionTitlesResponse;
import com.lubycon.curriculum.curriculum.dto.v2.CurriculumSectionsResponseV2;
import com.lubycon.curriculum.curriculum.dto.v2.IntroResponseV2;
import com.lubycon.curriculum.curriculum.exception.CurriculumNotFoundException;
import com.lubycon.curriculum.curriculum.repository.CurriculumRepository;
import com.lubycon.curriculum.section.domain.Section;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class CurriculumServiceTest {

  @Autowired
  CurriculumService curriculumService;

  @Autowired
  CurriculumRepository curriculumRepository;

  @Sql("/make-four-curriculums-only.sql")
  @DisplayName("커리큘럼 리스트를 가져온다.")
  @Test
  public void getCurriculumsOrderByIdDescTest() {
    // when
    final List<CurriculumResponse> curriculums = curriculumService.getCurriculums();

    // then
    assertThat(curriculums.size()).isEqualTo(3);
    assertThat(curriculums.get(0).getTitle()).isEqualTo("3번 커리큘럼의 제목");
    assertThat(curriculums.get(0).getDescription()).isEqualTo("3번 커리큘럼의 설명");
    assertThat(curriculums.get(0).getThumbnail()).isEqualTo("3번 커리큘럼의 썸네일");
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("특정 커리큘럼의 정보를 가져온다.")
  @Test
  public void getCurriculumsTest() {
    // when
    final CurriculumSectionsResponseV2 response = curriculumService.getCurriculumSectionsV2(1);

    // then
    final CurriculumInfoResponse curriculum = response.getCurriculum();
    assertThat(curriculum.getTitle()).isEqualTo("1번 커리큘럼의 제목");

    final IntroResponseV2 intro = response.getIntro();
    assertThat(intro.getDescription().getSummary()).isEqualTo("1번 커리큘럼의 핵심 설명");
    assertThat(intro.getDescription().getFooter()).isEqualTo("푸터");

    final SectionTitlesResponse section = response.getSections().get(2);
    assertThat(section.getOrder()).isEqualTo(2);
    assertThat(section.getId()).isEqualTo(300);
    assertThat(section.getTitle()).isEqualTo("1번 커리큘럼의 섹션3");
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("slug를 통해 특정 코스 정보를 가져온다.")
  @Test
  public void getCoursesBySlug() {
    // when
    final CurriculumSectionsResponseV2 response = curriculumService
        .getCoursesSectionsV2("curriculum-1");

    // then
    final CurriculumInfoResponse curriculum = response.getCurriculum();
    assertThat(curriculum.getTitle()).isEqualTo("1번 커리큘럼의 제목");

    final IntroResponseV2 intro = response.getIntro();
    assertThat(intro.getDescription().getSummary()).isEqualTo("1번 커리큘럼의 핵심 설명");
    assertThat(intro.getDescription().getFooter()).isEqualTo("푸터");

    final SectionTitlesResponse section = response.getSections().get(2);
    assertThat(section.getOrder()).isEqualTo(2);
    assertThat(section.getId()).isEqualTo(300);
    assertThat(section.getTitle()).isEqualTo("1번 커리큘럼의 섹션3");
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("커리큘럼이 없으면 예외가 발생한다.")
  @Test
  public void curriculumNotFoundTest() {
    // given
    final long notExistId = 1222;

    // when
    assertThatThrownBy(() -> curriculumService.getCurriculumSections(notExistId))
        .isInstanceOf(CurriculumNotFoundException.class)
        .hasMessageContaining(notExistId + "에 해당하는 커리큘럼이 없습니다."); // then
  }

  @DisplayName("커리큘럼을 저장한다.")
  @Test
  public void saveCurriculumsTest() {
    // given
    final String curriculumTitle = "React";
    final String curriculumDescription = "React는 전 세계에서 가장 많이 사용하는 UI 라이브러리입니다.";
    final String sectionTitle = "올바른 HTML 사용법";
    final String blogTitle = "제목3";

    final List<SaveBlog> blogs = Arrays
        .asList(new SaveBlog("제목1", "url1"), new SaveBlog("제목2", "url2"));
    final List<SaveBlog> blogs2 = Arrays
        .asList(new SaveBlog(blogTitle, "url3"), new SaveBlog("제목4", "url4"));

    final List<SaveSections> sections = Arrays.asList(SaveSections.builder()
            .title("올바른 CSS 사용법")
            .description("설명설명설명")
            .orderBy(1)
            .blogs(blogs)
            .build(),
        SaveSections.builder()
            .title(sectionTitle)
            .description("설명설명")
            .orderBy(2)
            .blogs(blogs2)
            .build());

    final SaveCurriculums curriculums = SaveCurriculums.builder()
        .title(curriculumTitle)
        .description(curriculumDescription)
        .thumbnail("썸네일")
        .sections(sections)
        .build();

    // when
    final long savedId = curriculumService.saveCurriculum(curriculums);

    // then
    final Curriculum savedCurriculums = curriculumRepository.findById(savedId).get();
    assertThat(savedCurriculums.getTitle()).isEqualTo(curriculumTitle);
    assertThat(savedCurriculums.getDescription()).isEqualTo(curriculumDescription);

    final Section savedSections = savedCurriculums.getSections().get(1);
    assertThat(savedSections.getTitle()).isEqualTo(sectionTitle);

    final Blog savedBlog = savedCurriculums.getSections().get(1).getBlogs().get(0);
    assertThat(savedBlog.getTitle()).isEqualTo(blogTitle);
  }

}