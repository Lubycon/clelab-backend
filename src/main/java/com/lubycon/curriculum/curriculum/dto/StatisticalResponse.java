package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.StatisticalInfo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class StatisticalResponse {

  @NotNull
  private final String title;

  @NotNull
  private final String description;

  @NotNull
  private final List<StatisticalValueResponse> values;

  public StatisticalResponse(final StatisticalInfo statisticalInfo) {
    this.title = statisticalInfo.getTitle();
    this.description = statisticalInfo.getDescription();
    this.values = statisticalInfo.getStatisticalValues()
        .stream()
        .map(StatisticalValueResponse::new)
        .collect(Collectors.toList());
  }
}
