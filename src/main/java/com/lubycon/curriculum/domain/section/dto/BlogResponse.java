package com.lubycon.curriculum.domain.section.dto;

import com.lubycon.curriculum.domain.blog.domain.Blog;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class BlogResponse {

  @NotNull
  private final Long id;

  @NotNull
  private final String title;

  @NotNull
  private final String link;

  private final boolean clelabPick;

  @NotNull
  private final String writer;

  private final int clapCount;

  public BlogResponse(final Blog blog) {
    this.id = blog.getId();
    this.title = blog.getTitle();
    this.link = blog.getLink();
    this.clelabPick = blog.isClelabPick();
    this.writer = blog.getWriter();
    this.clapCount = blog.getClapCount();
  }
}
