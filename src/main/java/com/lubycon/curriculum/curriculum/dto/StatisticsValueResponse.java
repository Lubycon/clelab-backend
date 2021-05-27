package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.StatisticsValue;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class StatisticsValueResponse {

  @NotNull
  private final String keyword;

  @NotNull
  private final String value;

  private final boolean courseTopic;

  public StatisticsValueResponse(final StatisticsValue statisticsValue) {
    this.keyword = statisticsValue.getKeyword();
    this.value = statisticsValue.getValue();
    this.courseTopic = statisticsValue.isCourseTopic();
  }
}
