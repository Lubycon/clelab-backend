package com.lubycon.curriculum.domain.curriculum.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.domain.curriculum.domain.Curriculum;
import com.lubycon.curriculum.domain.section.domain.IntroSection;
import com.lubycon.curriculum.domain.section.domain.Section;
import java.util.List;
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
  public void findByIdTest() {
    final Curriculum curriculum = curriculumRepository.findById(1L).get();
    final IntroSection introSection = curriculum.getIntroSection();
    final Section firstSection = curriculum.getSections().get(0);

    assertThat(curriculum.getTitle()).isEqualTo("1번 커리큘럼의 제목");
    assertThat(curriculum.getThumbnail()).isEqualTo("1번 커리큘럼의 썸네일");
    assertThat(firstSection.getDescription()).isEqualTo("1번 커리큘럼의 1번 섹션입니다.");
    assertThat(introSection.getDescription().getSummary()).isEqualTo("1번 커리큘럼의 핵심 설명");
  }


  @Sql("/make-four-curriculums-only.sql")
  @DisplayName("커리큘럼 리스트는 유효한 커리큘럼만 최신순으로 가져온다.")
  @Test
  public void getAllCurriculumsTest() {
    final List<Curriculum> curriculum = curriculumRepository.findAllCurriculums();

    assertThat(curriculum.size()).isEqualTo(3);
    assertThat(curriculum.get(0).getTitle()).isEqualTo("3번 커리큘럼의 제목");
  }

}