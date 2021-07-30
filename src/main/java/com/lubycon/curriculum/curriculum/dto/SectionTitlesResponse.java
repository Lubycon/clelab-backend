package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.Section;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class SectionTitlesResponse {

  private final long id;

  @NotNull
  private final String title;

  private final int order;

  private final String urlSlug;

  public SectionTitlesResponse(final Section section) {
    this.id = section.getId();
    this.title = section.getTitle();
    this.order = section.getOrder();
    this.urlSlug = section.getUrlSlug();
  }
}
