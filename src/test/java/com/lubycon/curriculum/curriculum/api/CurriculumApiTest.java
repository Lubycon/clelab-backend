package com.lubycon.curriculum.curriculum.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.lubycon.curriculum.base.ApiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.ResultActions;

class CurriculumApiTest extends ApiTest {

  @Sql("/make-four-curriculums-only.sql")
  @DisplayName("전체 커리큘럼 리스트를 가져온다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  public void getCurriculumTest(final int index) throws Exception {
    // given
    final String url = "/v1/curriculums";

    // when
    final ResultActions resultActions = mockMvc.perform(get(url));

    // then
    resultActions
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[%d].title", index).value(index + "번 커리큘럼의 제목"))
        .andExpect(jsonPath("$[%d].description", index).value(index + "번 커리큘럼의 설명"))
        .andExpect(jsonPath("$[%d].thumbnail", index).value(index + "번 커리큘럼의 썸네일"));
  }

}