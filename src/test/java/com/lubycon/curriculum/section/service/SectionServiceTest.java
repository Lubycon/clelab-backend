package com.lubycon.curriculum.section.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.section.dto.SectionResponse;
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
    SectionResponse findSection = sectionService.findSection(1, 1);

    // then
    assertThat(findSection.getTitle()).isEqualTo("1번 커리큘럼의 섹션2");
    assertThat(findSection.getOrder()).isEqualTo(1);
    assertThat(findSection.getDescription()).isEqualTo("1번 커리큘럼의 2번 섹션입니다.");
    assertThat(findSection.getBlogs().get(0).getTitle()).isEqualTo("2번 섹션의 블로그 제목1");
    assertThat(findSection.getPrevSection().getTitle()).isEqualTo("1번 커리큘럼의 섹션1");
    assertThat(findSection.getNextSection()).isNull();
  }
}