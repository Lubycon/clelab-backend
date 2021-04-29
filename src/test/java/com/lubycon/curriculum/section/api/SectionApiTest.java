package com.lubycon.curriculum.section.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.lubycon.curriculum.base.ApiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.ResultActions;

class SectionApiTest extends ApiTest {

  @Sql("/make-curriculum.sql")
  @DisplayName("특정 섹션의 내용을 가져온다.")
  @Test
  public void getSectionTest() throws Exception {
    // given
    String url = "/curriculums/{curriculumId}/sections/{sectionId}";

    // when
    final ResultActions resultActions = mockMvc.perform(get(url, 1, 1));

    // then
    resultActions
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].title").value("1번 커리큘럼의 섹션1"))
        .andExpect(jsonPath("$[0].description").value("1번 커리큘럼의 1번 섹션입니다."))
        .andExpect(jsonPath("$[0].blogs[0].title").value("1번 섹션의 블로그 제목1"))
        .andExpect(jsonPath("$[0].nextSection.title").value("1번 커리큘럼의 섹션2"));
  }

}