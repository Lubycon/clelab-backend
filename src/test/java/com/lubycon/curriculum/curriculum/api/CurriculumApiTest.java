package com.lubycon.curriculum.curriculum.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.lubycon.curriculum.base.ApiTest;
import org.junit.jupiter.api.DisplayName;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.ResultActions;

class CurriculumApiTest extends ApiTest {

  @Sql("/make-four-curriculums-only.sql")
  @DisplayName("전체 커리큘럼 리스트를 가져온다.")
  public void getCurriculumTest() throws Exception {
    // given
    final String url = "/v1/curriculums";

    // when
    final ResultActions resultActions = mockMvc.perform(get(url));

    // then
    resultActions
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[%d].title", 0).value("3번 커리큘럼의 제목"))
        .andExpect(jsonPath("$[%d].description", 0).value("3번 커리큘럼의 설명"))
        .andExpect(jsonPath("$[%d].thumbnail", 0).value("3번 커리큘럼의 썸네일"));
  }

}