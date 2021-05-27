package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.IntroSection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class IntroResponse {

  @NotNull
  private final IntroDescriptionResponse description;

  @NotNull
  private final MajorCompanyFrequencyResponse majorCompany;

  @NotNull
  private final GoogleTrendResponse googleTrend;

  @NotNull
  private final StackOverflowTrendResponse stackOverflowTrend;

  @NotNull
  private final List<StatisticalResponse> statistics;

  public IntroResponse(final IntroSection intro) {
    this.description = new IntroDescriptionResponse(intro.getDescription());
    this.majorCompany = new MajorCompanyFrequencyResponse(intro.getMajorCompanyFrequency());
    this.googleTrend = new GoogleTrendResponse(intro.getGoogleTrend());
    this.stackOverflowTrend = new StackOverflowTrendResponse(intro.getStackOverflowTrend());
    this.statistics = intro.getStatisticalInfo().stream()
        .map(StatisticalResponse::new)
        .collect(Collectors.toList());
  }


}
