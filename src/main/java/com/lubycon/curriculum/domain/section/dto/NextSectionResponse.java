package com.lubycon.curriculum.domain.section.dto;

import com.lubycon.curriculum.domain.section.domain.Section;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class NextSectionResponse {

  private final long id;

  @NotNull
  private final String title;

  @NotNull
  private final String urlSlug;

  public NextSectionResponse(final long id, @NotNull final String title,
      @NotNull final String urlSlug) {
    this.id = id;
    this.title = title;
    this.urlSlug = urlSlug;
  }

  public static NextSectionResponse fromEntity(final Section section) {
    return new NextSectionResponse(section.getId(), section.getTitle(), section.getUrlSlug());
  }
}
