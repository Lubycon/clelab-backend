package com.lubycon.curriculum.blog.service;

import com.lubycon.curriculum.blog.domain.Blog;
import com.lubycon.curriculum.blog.exception.BlogNotFoundException;
import com.lubycon.curriculum.blog.repository.BlogRepository;
import com.lubycon.curriculum.section.dto.BlogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BlogService {

  private final BlogRepository blogRepository;

  @Transactional
  public BlogResponse clap(final long blogId) {
    final Blog blog = getBlog(blogId);
    blog.clap();

    return new BlogResponse(blog);
  }

  private Blog getBlog(final long blogId) {
    return blogRepository.findById(blogId)
        .orElseThrow(BlogNotFoundException::new);
  }
}
