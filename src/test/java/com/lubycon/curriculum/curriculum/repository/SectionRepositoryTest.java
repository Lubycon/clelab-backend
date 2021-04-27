package com.lubycon.curriculum.curriculum.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.blog.domain.Blog;
import com.lubycon.curriculum.curriculum.domain.Section;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SectionRepositoryTest extends RepositoryTest {

  @Autowired
  private SectionRepository sectionRepository;

  @DisplayName("findById() 테스트")
  @Test
  public void findById() {
    Section findSection = sectionRepository.findById(1L).get();

    Blog findBlog = findSection.getLinks().get(0);
    assertThat(findBlog.getTitle()).isEqualTo("제목");
    assertThat(findBlog.getLink()).isEqualTo("링크1");
  }


}