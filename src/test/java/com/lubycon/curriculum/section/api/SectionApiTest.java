package com.lubycon.curriculum.section.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.lubycon.curriculum.base.ApiTest;
import com.lubycon.curriculum.blog.domain.Blog;
import com.lubycon.curriculum.blog.repository.BlogRepository;
import com.lubycon.curriculum.curriculum.domain.Curriculum;
import com.lubycon.curriculum.curriculum.repository.CurriculumRepository;
import com.lubycon.curriculum.section.domain.IntroSection;
import com.lubycon.curriculum.section.domain.Section;
import com.lubycon.curriculum.section.model.IntroDescription;
import com.lubycon.curriculum.section.repository.IntroSectionRepository;
import com.lubycon.curriculum.section.repository.SectionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

class SectionApiTest extends ApiTest {

  @Autowired
  CurriculumRepository curriculumRepository;

  @Autowired
  SectionRepository sectionRepository;

  @Autowired
  BlogRepository blogRepository;

  @Autowired
  IntroSectionRepository introSectionRepository;

  @DisplayName("특정 섹션의 내용을 가져온다.")
  @Test
  public void getSectionTest() throws Exception {
    // given
    String url = "/curriculums/{curriculumId}/sections/{sectionId}";

    Curriculum curriculum = generateCurriculum();
    Section section = generateSection(curriculum, 0);
    Section nextSection = generateSection(curriculum, 1);
    Blog blog = generateBlog(section);

    // when
    mockMvc.perform(get(url, curriculum.getId(), section.getId())
        .characterEncoding("UTF-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())  // then
        .andExpect(jsonPath("$[0].title").value(section.getTitle()))
        .andExpect(jsonPath("$[0].description").value(section.getDescription()))
        .andExpect(jsonPath("$[0].blogs[0].title").value(blog.getTitle()))
        .andExpect(jsonPath("$[0].nextSection.title").value(nextSection.getTitle()));
  }


  private Curriculum generateCurriculum() {
    Curriculum curriculum = Curriculum.builder()
        .title("커리큘럼 제목")
        .description("커리큘럼 설명")
        .thumbnail("커리큘럼 썸네일")
        .build();

    return curriculumRepository.save(curriculum);
  }

  private IntroSection generateIntroSection(Curriculum curriculum) {
    IntroSection introSection = IntroSection.builder()
        .description(IntroDescription.builder()
            .summary("인트로 요약")
            .description("인트로 설명")
            .build())
        .curriculum(curriculum)
        .build();

    return introSectionRepository.save(introSection);
  }

  private Section generateSection(Curriculum curriculum, int order) {
    Section section = Section.builder()
        .order(order)
        .title("섹션 제목" + order)
        .description("섹션 설명" + order)
        .curriculum(curriculum)
        .build();

    return sectionRepository.save(section);
  }

  private Blog generateBlog(Section section) {
    Blog blog = Blog.builder()
        .section(section)
        .link("블로그 링크")
        .title("블로그 제목")
        .build();

    return blogRepository.save(blog);
  }
}