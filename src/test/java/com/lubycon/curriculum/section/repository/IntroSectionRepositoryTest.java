package com.lubycon.curriculum.section.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.section.domain.IntroSection;
import com.lubycon.curriculum.section.domain.MajorCompanyFrequency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

class IntroSectionRepositoryTest extends RepositoryTest {

  @Autowired
  private IntroSectionRepository introSectionRepository;

  @Sql("/make-curriculum.sql")
  @DisplayName("메이저 회사 사용빈도 OneToOne() 테스트")
  @Test
  public void findById() {
    final IntroSection findIntroSection = introSectionRepository.findById(1L).get();
    final MajorCompanyFrequency majorCompanyFrequency = findIntroSection.getMajorCompanyFrequency();

    assertThat(majorCompanyFrequency.isNaver()).isTrue();
    assertThat(majorCompanyFrequency.isKakao()).isFalse();
    assertThat(majorCompanyFrequency.isLine()).isTrue();
  }

}