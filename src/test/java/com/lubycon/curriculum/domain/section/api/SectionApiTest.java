package com.lubycon.curriculum.domain.section.api;

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
  @DisplayName("slug를 사용해서 특정 커리큘럼의 섹션들을 가져온다.")
  @Test
  public void getAllSectionsFromSlug() throws Exception {
    // given
    final String url = "/courses/{courseSlug}/sections";

    // when
    final ResultActions resultActions = mockMvc.perform(get(url, "curriculum-1"));

    // then
    resultActions
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.curriculum.title").value("1번 커리큘럼의 제목"))
        .andExpect(jsonPath("$.intro.description.summary").value("1번 커리큘럼의 핵심 설명"))
        .andExpect(jsonPath("$.intro.description.subSummary").value("1번 커리큘럼의 핵심 설명2222"))
        .andExpect(jsonPath("$.intro.majorCompany.title").value("메이저 회사는 React를 얼마나 사용하고 있을까요?"))
        .andExpect(jsonPath("$.intro.majorCompany.companies.naver").value(true))
        .andExpect(jsonPath("$.intro.majorCompany.companies.kakao").value(false))
        .andExpect(jsonPath("$.intro.googleTrend.csvHtml").value("<p>안녕하세요</p>"))
        .andExpect(jsonPath("$.intro.stackOverflowTrend.title").value("스택오버플로우 트렌드"))
        .andExpect(jsonPath("$.intro.stackOverflowTrend.imagePath").value("스택오버플로우 이미지링크"))
        .andExpect(jsonPath("$.intro.statistics[0].title").value("관련 Github 레포지토리 수"))
        .andExpect(jsonPath("$.intro.statistics[0].values[0].keyword").value("React"))
        .andExpect(jsonPath("$.intro.statistics[0].values[0].value").value("220만"))
        .andExpect(jsonPath("$.sections[2].order").value(2))
        .andExpect(jsonPath("$.sections[2].id").value(300))
        .andExpect(jsonPath("$.sections[2].title").value("1번 커리큘럼의 섹션3"));
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("특정 섹션의 내용을 slug를 통해 가져온다.")
  @Test
  public void getSectionBySlugTest() throws Exception {
    // given
    final String url = "/courses/{curriculumSlug}/sections/{sectionSlug}";

    // when
    final ResultActions resultActions = mockMvc.perform(get(url, "curriculum-1", "three"));

    // then
    resultActions
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value("1번 커리큘럼의 섹션3"))
        .andExpect(jsonPath("$.order").value(2))
        .andExpect(jsonPath("$.description").value("1번 커리큘럼의 3번 섹션입니다."))
        .andExpect(jsonPath("$.blogs[0].title").value("3번 섹션의 블로그 제목1"))
        .andExpect(jsonPath("$.blogs[1].title").value("3번 섹션의 블로그 제목2"))
        .andExpect(jsonPath("$.blogs[1].writer").value("a"))
        .andExpect(jsonPath("$.blogs[0].clelabPick").value(false))
        .andExpect(jsonPath("$.blogs[1].clelabPick").value(true))
        .andExpect(jsonPath("$.nextSection.title").value("1번 커리큘럼의 섹션4"))
        .andExpect(jsonPath("$.prevSection.title").value("1번 커리큘럼의 섹션2"));
  }


}