package com.lubycon.curriculum.curriculum.dto;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public class IntroResponse {

  @Nullable
  private final String summary;

  @Nullable
  private final String description;

  public IntroResponse(@Nullable final String summary,
      @Nullable final String description) {
    this.summary = summary;
    this.description = description;
  }
}
