package com.lubycon.curriculum.curriculum.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.curriculum.domain.Curriculum;
import com.lubycon.curriculum.section.domain.IntroSection;
import com.lubycon.curriculum.section.domain.Section;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

class CurriculumRepositoryTest extends RepositoryTest {

  @Autowired
  private CurriculumRepository curriculumRepository;

  @Sql("/make-curriculum.sql")
  @DisplayName("findById() 테스트")
  @Test
  public void findById() {
    Curriculum curriculum = curriculumRepository.findById(1L).get();
    IntroSection introSection = curriculum.getIntroSection();
    Section firstSection = curriculum.getSections().get(0);

    assertThat(curriculum.getTitle()).isEqualTo("1번 커리큘럼의 제목");
    assertThat(curriculum.getThumbnail()).isEqualTo("1번 커리큘럼의 썸네일");
    assertThat(firstSection.getDescription()).isEqualTo("1번 커리큘럼의 1번 섹션입니다.");
    assertThat(introSection.getDescription().getSummary()).isEqualTo("1번 커리큘럼의 핵심 설명");
  }

}