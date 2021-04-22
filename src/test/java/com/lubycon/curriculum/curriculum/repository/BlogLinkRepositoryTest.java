package com.lubycon.curriculum.curriculum.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.curriculum.domain.BlogLink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class BlogLinkRepositoryTest extends RepositoryTest {

  @Autowired
  private BlogLinkRepository blogLinkRepository;

  private BlogLink blogLink;

  private static final String TITLE = "JUnit5의 기본적인 사용법들";
  private static final String LINK = "https://shinsunyoung.tistory.com/100";

  @BeforeEach
  public void setUp() {

    blogLink = blogLinkRepository.save(BlogLink.builder()
        .title(TITLE)
        .link(LINK)
        .build());
  }

  @DisplayName("findById() 테스트")
  @Test
  public void findById() {
    BlogLink link = blogLinkRepository.findById(this.blogLink.getId()).get();

    assertThat(link.getTitle()).isEqualTo(TITLE);
    assertThat(link.getLink()).isEqualTo(LINK);
  }
}