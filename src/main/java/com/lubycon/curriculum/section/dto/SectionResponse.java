package com.lubycon.curriculum.section.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SectionResponse {

  private final String title;
  private final String description;
  private final int order;
  private final List<BlogResponse> blogs;
  private final NextSectionResponse nextSection;
  private final PrevSectionResponse prevSection;

  @Builder
  public SectionResponse(String title, String description, int order,
      List<BlogResponse> blogs, NextSectionResponse nextSection,
      PrevSectionResponse prevSection) {
    this.title = title;
    this.description = description;
    this.order = order;
    this.blogs = blogs;
    this.nextSection = nextSection;
    this.prevSection = prevSection;
  }
}
