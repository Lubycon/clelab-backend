package com.lubycon.curriculum.curriculum.dto.v2;

import com.lubycon.curriculum.curriculum.domain.Curriculum;
import com.lubycon.curriculum.curriculum.dto.CurriculumInfoResponse;
import com.lubycon.curriculum.curriculum.dto.SectionTitlesResponse;
import com.lubycon.curriculum.section.domain.Section;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class CurriculumSectionsResponseV2 {

  @NotNull
  private final String thumbnail;

  @NotNull
  private final CurriculumInfoResponse curriculum;

  @NotNull
  private final IntroResponseV2 intro;

  @NotNull
  private final List<SectionTitlesResponse> sections;


  @Builder
  private CurriculumSectionsResponseV2(
      @NotNull final String thumbnail,
      @NotNull final CurriculumInfoResponse curriculum,
      @NotNull final IntroResponseV2 intro,
      @NotNull final List<SectionTitlesResponse> sections) {
    this.thumbnail = thumbnail;
    this.curriculum = curriculum;
    this.intro = intro;
    this.sections = sections;
  }

  public static CurriculumSectionsResponseV2 toResponse(final Curriculum curriculum) {
    final List<Section> sections = curriculum.getSections();

    return CurriculumSectionsResponseV2.builder()
        .thumbnail(curriculum.getThumbnail())
        .intro(new IntroResponseV2(curriculum.getIntroSection()))
        .curriculum(new CurriculumInfoResponse(curriculum.getId(), curriculum.getTitle()))
        .sections(sections.stream()
            .map(SectionTitlesResponse::new)
            .collect(Collectors.toList()))
        .build();
  }
}
