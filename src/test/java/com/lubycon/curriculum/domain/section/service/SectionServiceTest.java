package com.lubycon.curriculum.domain.section.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.lubycon.curriculum.domain.section.dto.SectionResponse;
import com.lubycon.curriculum.domain.section.exception.SectionNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class SectionServiceTest {

  @Autowired
  SectionService sectionService;

  @Sql("/make-curriculum.sql")
  @DisplayName("특정 섹션의 내용을 가져온다.")
  @Test
  public void getSectionTest() {
    // when
    final SectionResponse findSection = sectionService.findSection(1, 300);

    // then
    assertThat(findSection.getTitle()).isEqualTo("1번 커리큘럼의 섹션3");
    assertThat(findSection.getOrder()).isEqualTo(2);
    assertThat(findSection.getDescription()).isEqualTo("1번 커리큘럼의 3번 섹션입니다.");
    assertThat(findSection.getBlogs().get(0).getTitle()).isEqualTo("3번 섹션의 블로그 제목1");
    assertThat(findSection.getPrevSection().getTitle()).isEqualTo("1번 커리큘럼의 섹션2");
    assertThat(findSection.getNextSection().getTitle()).isEqualTo("1번 커리큘럼의 섹션4");
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("slug를 통해 특정 섹션의 내용을 가져온다.")
  @Test
  public void getSectionBySlugTest() {
    // when
    final SectionResponse findSection = sectionService.findSectionBySlug("curriculum-1", "three");

    // then
    assertThat(findSection.getTitle()).isEqualTo("1번 커리큘럼의 섹션3");
    assertThat(findSection.getOrder()).isEqualTo(2);
    assertThat(findSection.getDescription()).isEqualTo("1번 커리큘럼의 3번 섹션입니다.");
    assertThat(findSection.getBlogs().get(0).getTitle()).isEqualTo("3번 섹션의 블로그 제목1");
    assertThat(findSection.getPrevSection().getTitle()).isEqualTo("1번 커리큘럼의 섹션2");
    assertThat(findSection.getNextSection().getTitle()).isEqualTo("1번 커리큘럼의 섹션4");
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("섹션이 없으면 예외가 발생한다.")
  @Test
  public void curriculumNotFoundTest() {
    // given
    final long notExistId = 1222;

    // when
    assertThatThrownBy(() -> sectionService.findSection(1, notExistId))
        .isInstanceOf(SectionNotFoundException.class)
        .hasMessageContaining(notExistId + "에 해당하는 섹션이 없습니다."); // then
  }

}