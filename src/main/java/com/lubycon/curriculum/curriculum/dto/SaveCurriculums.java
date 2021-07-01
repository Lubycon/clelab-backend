package com.lubycon.curriculum.curriculum.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveCurriculums {

  private String title;
  private String description;
  private String thumbnail;
  private List<SaveSections> sections;

  @Builder
  public SaveCurriculums(final String title, final String description, final String thumbnail,
      final List<SaveSections> sections) {
    this.title = title;
    this.description = description;
    this.thumbnail = thumbnail;
    this.sections = sections;
  }
}
