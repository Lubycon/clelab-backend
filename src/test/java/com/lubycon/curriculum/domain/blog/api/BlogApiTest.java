package com.lubycon.curriculum.domain.blog.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.lubycon.curriculum.base.ApiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.ResultActions;

class BlogApiTest extends ApiTest {

  @Sql("/make-curriculum.sql")
  @DisplayName("블로그 글에 박수를 쳐 박수 카운트를 증가시킨.")
  @Test
  public void clapCount() throws Exception {
    // given
    final String url = "/blogs/{blogId}/clap";
    final long blogId = 1;

    // when
    final ResultActions resultActions = mockMvc.perform(put(url, blogId));

    // then
    resultActions
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value("1번 섹션의 블로그 제목1"))
        .andExpect(jsonPath("$.clapCount").value("1"));
  }

}