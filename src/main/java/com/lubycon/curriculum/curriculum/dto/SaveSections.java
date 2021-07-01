package com.lubycon.curriculum.curriculum.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveSections {

  private String title;
  private String description;
  private Integer orderBy;
  private List<SaveBlog> blogs;

  @Builder
  public SaveSections(final String title, final String description, final Integer orderBy,
      final List<SaveBlog> blogs) {
    this.title = title;
    this.description = description;
    this.orderBy = orderBy;
    this.blogs = blogs;
  }
}
