package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.model.IntroDescription;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public class IntroResponse {

  @Nullable
  private final String summary;

  @Nullable
  private final String description;

  public IntroResponse(final IntroDescription intro) {
    this.summary = intro.getSummary();
    this.description = intro.getDescription();
  }


}
