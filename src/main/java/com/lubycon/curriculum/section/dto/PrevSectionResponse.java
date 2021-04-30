package com.lubycon.curriculum.section.dto;

import com.lubycon.curriculum.section.domain.Section;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public class PrevSectionResponse {

  @Nullable
  private final Long id;

  @Nullable
  private final String title;

  public PrevSectionResponse(@Nullable final Long id, @Nullable final String title) {
    this.id = id;
    this.title = title;
  }

  public static PrevSectionResponse fromEntity(final Section section) {
    return new PrevSectionResponse(section.getId(), section.getTitle());
  }

  public static PrevSectionResponse empty() {
    return new PrevSectionResponse(null, null);
  }
}
