package com.lubycon.curriculum.section.dto;

import com.lubycon.curriculum.section.domain.Section;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class NextSectionResponse {

  private final long id;

  @NotNull
  private final String title;

  public NextSectionResponse(final long id, @NotNull final String title) {
    this.id = id;
    this.title = title;
  }

  public static NextSectionResponse fromEntity(final Section section) {
    return new NextSectionResponse(section.getId(), section.getTitle());
  }
}
