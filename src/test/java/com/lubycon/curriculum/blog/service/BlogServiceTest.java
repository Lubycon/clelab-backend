package com.lubycon.curriculum.blog.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.blog.domain.Blog;
import com.lubycon.curriculum.blog.repository.BlogRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class BlogServiceTest {

  @Autowired
  BlogService blogService;

  @Autowired
  BlogRepository blogRepository;


  @Sql("/make-curriculum.sql")
  @DisplayName("블로그 글에 박수를 치면 카운트를 증가한다.")
  @Test
  public void getCurriculumsOrderByIdDescTest() {
    // given
    final long blogId = 1;
    final Blog blog = blogRepository.findById(blogId).get();
    assertThat(blog.getClapCount()).isEqualTo(0);

    // when
    blogService.clap(blogId);

    // then
    final Blog clappedBlog = blogRepository.findById(blogId).get();
    assertThat(clappedBlog.getClapCount()).isEqualTo(1);
  }


}