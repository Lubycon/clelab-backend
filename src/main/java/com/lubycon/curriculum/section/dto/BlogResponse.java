package com.lubycon.curriculum.section.dto;

import com.lubycon.curriculum.blog.domain.Blog;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class BlogResponse {

  @NotNull
  private final String title;

  @NotNull
  private final String link;

  private final boolean clelabPick;

  private final String writer;

  public BlogResponse(final Blog blog) {
    this.title = blog.getTitle();
    this.link = blog.getLink();
    this.clelabPick = blog.isClelabPick();
    this.writer = blog.getWriter();
  }
}
