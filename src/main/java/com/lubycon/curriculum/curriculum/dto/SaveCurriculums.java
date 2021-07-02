package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.curriculum.domain.Curriculum;
import java.util.List;
import java.util.stream.Collectors;
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
  private IntroSectionDto intro;

  @Builder
  public SaveCurriculums(final String title, final String description, final String thumbnail,
      final List<SaveSections> sections, final IntroSectionDto intro) {
    this.title = title;
    this.description = description;
    this.thumbnail = thumbnail;
    this.sections = sections;
    this.intro = intro;
  }


  public Curriculum toEntity() {
    return Curriculum.builder()
        .title(title)
        .description(description)
        .thumbnail(thumbnail)
        .introSection(intro == null ? null : intro.toEntity())
        .sections(sections.stream()
            .map(SaveSections::toEntity)
            .collect(Collectors.toList()))
        .build();
  }
}
