package com.lubycon.curriculum.curriculum.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.lubycon.curriculum.curriculum.dto.CurriculumInfoResponse;
import com.lubycon.curriculum.curriculum.dto.CurriculumResponse;
import com.lubycon.curriculum.curriculum.dto.SectionTitlesResponse;
import com.lubycon.curriculum.curriculum.dto.v2.CurriculumSectionsResponseV2;
import com.lubycon.curriculum.curriculum.dto.v2.IntroResponseV2;
import com.lubycon.curriculum.curriculum.exception.CurriculumNotFoundException;
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

  @Sql("/make-four-curriculums-only.sql")
  @DisplayName("커리큘럼 리스트를 가져온다.")
  @Test
  public void getCurriculumsOrderByIdDescTest() {
    // when
    final List<CurriculumResponse> curriculums = curriculumService.getCurriculums();

    // then
    assertThat(curriculums.size()).isEqualTo(4);
    assertThat(curriculums.get(0).getTitle()).isEqualTo(3 + "번 커리큘럼의 제목");
    assertThat(curriculums.get(0).getDescription()).isEqualTo(3 + "번 커리큘럼의 설명");
    assertThat(curriculums.get(0).getThumbnail()).isEqualTo(3 + "번 커리큘럼의 썸네일");
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

}