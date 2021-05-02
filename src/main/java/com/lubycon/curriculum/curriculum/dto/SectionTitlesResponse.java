package com.lubycon.curriculum.curriculum.dto;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class SectionTitlesResponse {

  private final long id;

  @NotNull
  private final String title;

  private final int order;

  public SectionTitlesResponse(final long id, @NotNull final String title, final int order) {
    this.id = id;
    this.title = title;
    this.order = order;
  }
}
