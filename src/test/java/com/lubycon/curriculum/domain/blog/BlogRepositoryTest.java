package com.lubycon.curriculum.domain.blog;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.domain.blog.domain.Blog;
import com.lubycon.curriculum.domain.blog.repository.BlogRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

class BlogRepositoryTest extends RepositoryTest {

  @Autowired
  private BlogRepository blogRepository;

  @Sql("/make-curriculum.sql")
  @DisplayName("findById() 테스트")
  @Test
  public void findById() {
    final Blog link = blogRepository.findById(1L).get();

    assertThat(link.getTitle()).isEqualTo("1번 섹션의 블로그 제목1");
    assertThat(link.getLink()).isEqualTo("1번 섹션의 블로그 링크1");
  }
}