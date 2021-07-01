package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.IntroSection;
import com.lubycon.curriculum.section.model.IntroDescription;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Setter
@Getter
public class IntroSectionRequest {

  @NotNull
  private String summary;

  @NotNull
  private String subSummary;

  @NotNull
  private String footer;

  @NotNull
  private String header;

  private MajorCompaniesDto majorCompany;

  private StackOverflowTrendDto stackOverflowTrend;

  private List<StatisticalDto> statistics;

  public IntroSection toEntity() {
    return IntroSection.builder()
        .description(IntroDescription.builder()
            .summary(summary)
            .header(header)
            .footer(footer)
            .subSummary(subSummary)
            .build())
        .majorCompanyFrequency(majorCompany.toEntity())
        .stackOverflowTrend(stackOverflowTrend.toEntity())
        .statisticalInfo(statistics.stream()
            .map(StatisticalDto::toEntity)
            .collect(Collectors.toList()))
        .build();
  }

}
