package com.lubycon.curriculum.curriculum.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.curriculum.dto.CurriculumInfoResponse;
import com.lubycon.curriculum.curriculum.dto.CurriculumResponse;
import com.lubycon.curriculum.curriculum.dto.CurriculumSectionsResponse;
import com.lubycon.curriculum.curriculum.dto.IntroResponse;
import com.lubycon.curriculum.curriculum.dto.SectionTitlesResponse;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  public void getCurriculumsTest(final int index) {
    // when
    final List<CurriculumResponse> curriculums = curriculumService.getCurriculums();

    // then
    assertThat(curriculums.size()).isEqualTo(4);
    assertThat(curriculums.get(index).getTitle()).isEqualTo(index + "번 커리큘럼의 제목");
    assertThat(curriculums.get(index).getDescription()).isEqualTo(index + "번 커리큘럼의 설명");
    assertThat(curriculums.get(index).getThumbnail()).isEqualTo(index + "번 커리큘럼의 썸네일");
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("특정 커리큘럼의 정보를 가져온다.")
  @Test
  public void getCurriculumsTest() {
    // when
    final CurriculumSectionsResponse response = curriculumService.getCurriculumSections(1);

    // then
    final CurriculumInfoResponse curriculum = response.getCurriculum();
    assertThat(curriculum.getTitle()).isEqualTo("1번 커리큘럼의 제목");

    final IntroResponse intro = response.getIntro();
    assertThat(intro.getSummary()).isEqualTo("1번 커리큘럼의 핵심 설명");
    assertThat(intro.getDescription()).isEqualTo("1번 커리큘럼의 설명");

    final SectionTitlesResponse section = response.getSections().get(2);
    assertThat(section.getOrder()).isEqualTo(2);
    assertThat(section.getId()).isEqualTo(300);
    assertThat(section.getTitle()).isEqualTo("1번 커리큘럼의 섹션3");
  }

}