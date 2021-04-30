package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.curriculum.domain.Curriculum;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public class CurriculumResponse {

  private final long id;

  @NotNull
  private final String title;

  @Nullable
  private final String description;

  @NotNull
  private final String thumbnail;

  public CurriculumResponse(final Curriculum curriculum) {
    this.id = curriculum.getId();
    this.title = curriculum.getTitle();
    this.description = curriculum.getDescription();
    this.thumbnail = curriculum.getThumbnail();
  }
}
