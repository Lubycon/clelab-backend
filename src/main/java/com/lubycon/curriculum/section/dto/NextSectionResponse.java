package com.lubycon.curriculum.section.dto;

import com.lubycon.curriculum.section.domain.Section;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class NextSectionResponse {

  private final long id;

  @NotNull
  private final String title;

  private NextSectionResponse(long id, @NotNull String title) {
    this.id = id;
    this.title = title;
  }

  public static NextSectionResponse fromEntity(Section section) {
    return new NextSectionResponse(section.getId(), section.getTitle());
  }
}
