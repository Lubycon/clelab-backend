package com.lubycon.curriculum.domain.curriculum.dto;

import com.lubycon.curriculum.domain.curriculum.domain.Curriculum;
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

  @NotNull
  private final String urlSlug;

  public CurriculumResponse(final Curriculum curriculum) {
    this.id = curriculum.getId();
    this.title = curriculum.getTitle();
    this.description = curriculum.getDescription();
    this.thumbnail = curriculum.getThumbnail();
    this.urlSlug = curriculum.getUrlSlug();
  }
}
