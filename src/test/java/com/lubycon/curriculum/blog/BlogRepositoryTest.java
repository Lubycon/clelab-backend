package com.lubycon.curriculum.blog;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.blog.domain.Blog;
import com.lubycon.curriculum.blog.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class BlogRepositoryTest extends RepositoryTest {

  @Autowired
  private BlogRepository blogRepository;

  private Blog blog;

  private static final String TITLE = "JUnit5의 기본적인 사용법들";
  private static final String LINK = "https://shinsunyoung.tistory.com/100";

  @BeforeEach
  public void setUp() {

    blog = blogRepository.save(Blog.builder()
        .title(TITLE)
        .link(LINK)
        .build());
  }

  @DisplayName("findById() 테스트")
  @Test
  public void findById() {
    Blog link = blogRepository.findById(this.blog.getId()).get();

    assertThat(link.getTitle()).isEqualTo(TITLE);
    assertThat(link.getLink()).isEqualTo(LINK);
  }
}