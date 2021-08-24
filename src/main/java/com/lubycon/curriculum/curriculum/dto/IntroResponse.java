package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.IntroSection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public class IntroResponse {

  @Nullable
  private final IntroDescriptionDto description;

  @Nullable
  private final MajorCompanyFrequencyDto majorCompany;

  @Nullable
  private final GoogleTrendDto googleTrend;

  @Nullable
  private final StackOverflowTrendDto stackOverflowTrend;

  @NotNull
  private final List<StatisticalDto> statistics;

  public IntroResponse(final IntroSection intro) {
    this.description =
        intro.getDescription() == null ? null : new IntroDescriptionDto(intro.getDescription());
    this.majorCompany = intro.getMajorCompanyFrequency() == null ? null
        : new MajorCompanyFrequencyDto(intro.getMajorCompanyFrequency());
    this.googleTrend =
        intro.getGoogleTrend() == null ? null : new GoogleTrendDto(intro.getGoogleTrend());
    this.stackOverflowTrend = intro.getStackOverflowTrend() == null ? null
        : new StackOverflowTrendDto(intro.getStackOverflowTrend());
    this.statistics = intro.getStatisticalInfo().stream()
        .map(StatisticalDto::new)
        .collect(Collectors.toList());
  }


}
