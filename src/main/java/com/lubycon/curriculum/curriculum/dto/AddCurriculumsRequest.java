package com.lubycon.curriculum.curriculum.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCurriculumsRequest {

  private String title;
  private String description;
  private String thumbnail;
  private List<SectionsRequest> sections;

  public SaveCurriculums toServiceDto() {
    return SaveCurriculums.builder()
        .title(title)
        .description(description)
        .thumbnail(thumbnail)
        .sections(sections.stream()
            .map(SectionsRequest::toServiceDto)
            .collect(Collectors.toList()))
        .build();
  }

  @Builder
  public AddCurriculumsRequest(final String title, final String description, final String thumbnail,
      final List<SectionsRequest> sections) {
    this.title = title;
    this.description = description;
    this.thumbnail = thumbnail;
    this.sections = sections;
  }
}
