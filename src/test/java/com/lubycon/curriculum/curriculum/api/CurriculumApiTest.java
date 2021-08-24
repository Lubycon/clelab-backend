package com.lubycon.curriculum.curriculum.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.lubycon.curriculum.base.ApiTest;
import com.lubycon.curriculum.curriculum.dto.AddCurriculumsRequest;
import com.lubycon.curriculum.curriculum.dto.BlogRequest;
import com.lubycon.curriculum.curriculum.dto.SectionsRequest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.ResultActions;

class CurriculumApiTest extends ApiTest {

  @Sql("/make-four-curriculums-only.sql")
  @DisplayName("전체 커리큘럼 리스트를 가져온다.")
  @Test
  public void getCurriculumTest() throws Exception {
    // given
    final String url = "/curriculums";

    // when
    final ResultActions resultActions = mockMvc.perform(get(url));

    // then
    resultActions
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[%d].title", 0).value("3번 커리큘럼의 제목"))
        .andExpect(jsonPath("$[%d].description", 0).value("3번 커리큘럼의 설명"))
        .andExpect(jsonPath("$[%d].thumbnail", 0).value("3번 커리큘럼의 썸네일"));
  }

  @DisplayName("커리큘럼을 저장한다.")
  @Test
  public void saveCurriculumTest() throws Exception {
    // given
    final String url = "/curriculums";

    final String curriculumTitle = "React";
    final String curriculumDescription = "React는 전 세계에서 가장 많이 사용하는 UI 라이브러리입니다.";

    final List<BlogRequest> blogs = Arrays
        .asList(new BlogRequest("제목1", "url1"), new BlogRequest("제목2", "url2"));

    final List<SectionsRequest> sections = Arrays.asList(SectionsRequest.builder()
        .title("올바른 CSS 사용법")
        .description("설명설명설명")
        .orderBy(1)
        .blogs(blogs)
        .build());

    final AddCurriculumsRequest curriculums = AddCurriculumsRequest.builder()
        .title(curriculumTitle)
        .description(curriculumDescription)
        .thumbnail("썸네일")
        .sections(sections)
        .build();

    // when
    final ResultActions resultActions = mockMvc.perform(post(url)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(curriculums)));

    // then
    resultActions
        .andExpect(status().isCreated());
  }

  @DisplayName("커리큘럼을 저장할 때, 유효성 제목이 없으면 400 에러가 난다.")
  @Test
  public void saveCurriculum400Test() throws Exception {
    // given
    final String url = "/curriculums";

    final List<BlogRequest> blogs = Arrays.asList(new BlogRequest("제목1", "url1"));

    final List<SectionsRequest> sections = Arrays.asList(SectionsRequest.builder()
        .title("제목")
        .description("설명설명설명")
        .orderBy(1)
        .blogs(blogs)
        .build());

    final AddCurriculumsRequest curriculums = AddCurriculumsRequest.builder()
        .title(null)
        .description("설명")
        .thumbnail("썸네일")
        .sections(sections)
        .build();

    // when
    final ResultActions resultActions = mockMvc.perform(post(url)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(curriculums)));

    // then
    resultActions
        .andExpect(status().isBadRequest());
  }

}