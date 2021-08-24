package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.curriculum.domain.Curriculum;
import com.lubycon.curriculum.section.domain.Section;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class CurriculumSectionsResponse {

  @NotNull
  private final String thumbnail;

  @NotNull
  private final CurriculumInfoResponse curriculum;

  @NotNull
  private final IntroResponse intro;

  @NotNull
  private final List<SectionTitlesResponse> sections;


  @Builder
  private CurriculumSectionsResponse(
      @NotNull final String thumbnail,
      @NotNull final CurriculumInfoResponse curriculum,
      @NotNull final IntroResponse intro,
      @NotNull final List<SectionTitlesResponse> sections) {
    this.thumbnail = thumbnail;
    this.curriculum = curriculum;
    this.intro = intro;
    this.sections = sections;
  }

  public static CurriculumSectionsResponse toResponse(final Curriculum curriculum) {
    final List<Section> sections = curriculum.getSections();

    return CurriculumSectionsResponse.builder()
        .thumbnail(curriculum.getThumbnail())
        .intro(new IntroResponse(curriculum.getIntroSection()))
        .curriculum(new CurriculumInfoResponse(curriculum.getId(), curriculum.getTitle()))
        .sections(sections.stream()
            .map(SectionTitlesResponse::new)
            .collect(Collectors.toList()))
        .build();
  }
}
