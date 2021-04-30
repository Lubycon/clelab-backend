package com.lubycon.curriculum.section.dto;

import com.lubycon.curriculum.section.domain.Section;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public class NextSectionResponse {

  @Nullable
  private final Long id;

  @Nullable
  private final String title;

  public NextSectionResponse(@Nullable final Long id, @Nullable final String title) {
    this.id = id;
    this.title = title;
  }

  public static NextSectionResponse fromEntity(final Section section) {
    return new NextSectionResponse(section.getId(), section.getTitle());
  }

  public static NextSectionResponse empty() {
    return new NextSectionResponse(null, null);
  }
}
