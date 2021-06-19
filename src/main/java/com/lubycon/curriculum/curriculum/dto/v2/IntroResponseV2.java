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
import org.jetbrains.annotations.Nullable;

@Getter
public class IntroResponseV2 {

  @Nullable
  private final IntroDescriptionResponse description;

  @Nullable
  private final MajorCompanyFrequencyResponse majorCompany;

  @Nullable
  private final GoogleTrendResponse googleTrend;

  @Nullable
  private final StackOverflowTrendResponse stackOverflowTrend;

  @NotNull
  private final List<StatisticalResponse> statistics;

  public IntroResponseV2(final IntroSection intro) {
    this.description = intro.getDescription() == null ? null : new IntroDescriptionResponse(intro.getDescription());
    this.majorCompany = intro.getMajorCompanyFrequency() == null ? null : new MajorCompanyFrequencyResponse(intro.getMajorCompanyFrequency());
    this.googleTrend = intro.getGoogleTrend() == null ? null : new GoogleTrendResponse(intro.getGoogleTrend());
    this.stackOverflowTrend = intro.getStackOverflowTrend() == null ? null : new StackOverflowTrendResponse(intro.getStackOverflowTrend());
    this.statistics = intro.getStatisticalInfo().stream()
        .map(StatisticalResponse::new)
        .collect(Collectors.toList());
  }


}
