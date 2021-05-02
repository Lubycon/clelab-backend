package com.lubycon.curriculum.curriculum.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class CurriculumSectionsResponse {

  @NotNull
  private final CurriculumInfoResponse curriculum;

  @NotNull
  private final IntroResponse intro;

  @NotNull
  private final List<SectionTitlesResponse> sections;


  @Builder
  public CurriculumSectionsResponse(
      @NotNull final CurriculumInfoResponse curriculum,
      @NotNull final IntroResponse intro,
      @NotNull final List<SectionTitlesResponse> sections) {
    this.curriculum = curriculum;
    this.intro = intro;
    this.sections = sections;
  }
}
