package com.lubycon.curriculum.section.dto;

import com.lubycon.curriculum.section.domain.Section;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class PrevSectionResponse {

  private final long id;

  @NotNull
  private final String title;

  private PrevSectionResponse(long id, @NotNull String title) {
    this.id = id;
    this.title = title;
  }

  public static PrevSectionResponse fromEntity(Section section) {
    return new PrevSectionResponse(section.getId(), section.getTitle());
  }
}
