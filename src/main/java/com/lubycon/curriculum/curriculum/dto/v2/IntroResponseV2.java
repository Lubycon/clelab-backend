package com.lubycon.curriculum.curriculum.dto.v2;

import com.lubycon.curriculum.curriculum.dto.GoogleTrendResponse;
import com.lubycon.curriculum.curriculum.dto.IntroDescriptionResponse;
import com.lubycon.curriculum.curriculum.dto.MajorCompanyFrequencyResponse;
import com.lubycon.curriculum.curriculum.dto.StackOverflowTrendResponse;
import com.lubycon.curriculum.curriculum.dto.StatisticalResponse;
import com.lubycon.curriculum.section.domain.IntroSection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class IntroResponseV2 {

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

  public IntroResponseV2(final IntroSection intro) {
    this.description = new IntroDescriptionResponse(intro.getDescription());
    this.majorCompany = new MajorCompanyFrequencyResponse(intro.getMajorCompanyFrequency());
    this.googleTrend = new GoogleTrendResponse(intro.getGoogleTrend());
    this.stackOverflowTrend = new StackOverflowTrendResponse(intro.getStackOverflowTrend());
    this.statistics = intro.getStatisticalInfo().stream()
        .map(StatisticalResponse::new)
        .collect(Collectors.toList());
  }


}
