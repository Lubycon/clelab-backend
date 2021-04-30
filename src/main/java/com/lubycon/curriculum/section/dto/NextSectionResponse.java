package com.lubycon.curriculum.section.dto;

import com.lubycon.curriculum.section.domain.Section;
import lombok.Getter;

@Getter
public class NextSectionResponse {

  private final long id;
  private final String title;

  private NextSectionResponse(long id, String title) {
    this.id = id;
    this.title = title;
  }

  public static NextSectionResponse fromEntity(Section section) {
    return new NextSectionResponse(section.getId(), section.getTitle());
  }
}
