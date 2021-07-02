package com.lubycon.curriculum.curriculum.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SectionsRequest {

  private String title;
  private String description;
  private Integer orderBy;
  private List<BlogRequest> blogs;

  public SaveSections toServiceDto() {
    return SaveSections.builder()
        .title(title)
        .description(description)
        .orderBy(orderBy)
        .blogs(blogs.stream()
            .map(BlogRequest::toServiceDto)
            .collect(Collectors.toList()))
        .build();
  }

  @Builder
  public SectionsRequest(final String title, final String description, final Integer orderBy,
      final List<BlogRequest> blogs) {
    this.title = title;
    this.description = description;
    this.orderBy = orderBy;
    this.blogs = blogs;
  }
}
