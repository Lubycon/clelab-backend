package com.lubycon.curriculum.domain.curriculum.dto;

import com.lubycon.curriculum.domain.section.domain.Section;
import java.util.List;
import java.util.stream.Collectors;
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

  public Section toEntity() {
    return Section.builder()
        .title(title)
        .description(description)
        .order(orderBy)
        .blogs(blogs
            .stream()
            .map(SaveBlog::toEntity)
            .collect(Collectors.toList()))
        .build();
  }
}
