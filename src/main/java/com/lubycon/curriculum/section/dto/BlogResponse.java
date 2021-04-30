package com.lubycon.curriculum.section.dto;

import com.lubycon.curriculum.blog.domain.Blog;
import lombok.Getter;

@Getter
public class BlogResponse {

  private final String title;
  private final String link;

  public BlogResponse(Blog blog) {
    this.title = blog.getTitle();
    this.link = blog.getLink();
  }
}
