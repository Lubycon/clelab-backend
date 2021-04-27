package com.lubycon.curriculum.curriculum.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.curriculum.domain.Curriculum;
import com.lubycon.curriculum.section.domain.IntroSection;
import com.lubycon.curriculum.section.domain.Section;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CurriculumRepositoryTest extends RepositoryTest {

  @Autowired
  private CurriculumRepository curriculumRepository;

  @DisplayName("findById() 테스트")
  @Test
  public void findById() {
    Curriculum curriculum = curriculumRepository.findById(1L).get();
    IntroSection introSection = curriculum.getIntroSection();
    Section firstSection = curriculum.getSections().get(0);

    assertThat(curriculum.getTitle()).isEqualTo("제목");
    assertThat(curriculum.getThumbnail()).isEqualTo("썸네일");
    assertThat(firstSection.getDescription()).isEqualTo("설명");
    assertThat(introSection.getDescription().getSummary()).isEqualTo("핵심 설명");
  }

}