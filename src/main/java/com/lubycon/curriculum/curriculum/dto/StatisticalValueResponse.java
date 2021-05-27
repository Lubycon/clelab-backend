package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.StatisticalValue;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class StatisticalValueResponse {

  @NotNull
  private final String keyword;

  @NotNull
  private final String value;

  private final boolean courseTopic;

  public StatisticalValueResponse(final StatisticalValue statisticalValue) {
    this.keyword = statisticalValue.getKeyword();
    this.value = statisticalValue.getValue();
    this.courseTopic = statisticalValue.isCourseTopic();
  }
}
