package com.lubycon.curriculum.curriculum.dto;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class CurriculumInfoResponse {

  private final long id;

  @NotNull
  private final String title;

  public CurriculumInfoResponse(final long id, @NotNull final String title) {
    this.id = id;
    this.title = title;
  }
}
