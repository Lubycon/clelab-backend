package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.StatisticsInfo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class StatisticsResponse {

  @NotNull
  private final String title;

  @NotNull
  private final String description;

  @NotNull
  private final List<StatisticsValueResponse> values;

  public StatisticsResponse(final StatisticsInfo statisticsInfo) {
    this.title = statisticsInfo.getTitle();
    this.description = statisticsInfo.getDescription();
    this.values = statisticsInfo.getStatisticsValues()
        .stream()
        .map(StatisticsValueResponse::new)
        .collect(Collectors.toList());
  }
}
