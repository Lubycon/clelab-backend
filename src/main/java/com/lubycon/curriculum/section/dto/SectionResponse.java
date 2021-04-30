package com.lubycon.curriculum.section.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public class SectionResponse {

  @NotNull
  private final String title;

  @Nullable
  private final String description;

  private final int order;

  @NotNull
  private final List<BlogResponse> blogs;

  @Nullable
  private final NextSectionResponse nextSection;

  @Nullable
  private final PrevSectionResponse prevSection;

  @Builder
  public SectionResponse(@NotNull String title, @Nullable String description, int order,
      @NotNull List<BlogResponse> blogs, @Nullable NextSectionResponse nextSection,
      @Nullable PrevSectionResponse prevSection) {
    this.title = title;
    this.description = description;
    this.order = order;
    this.blogs = blogs;
    this.nextSection = nextSection;
    this.prevSection = prevSection;
  }
}
