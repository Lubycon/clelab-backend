package com.lubycon.curriculum.section.dto;

import com.lubycon.curriculum.section.domain.Section;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class PrevSectionResponse {

  private final long id;

  @NotNull
  private final String title;

  public PrevSectionResponse(final long id, @NotNull final String title) {
    this.id = id;
    this.title = title;
  }

  public static PrevSectionResponse fromEntity(final Section section) {
    return new PrevSectionResponse(section.getId(), section.getTitle());
  }
}
