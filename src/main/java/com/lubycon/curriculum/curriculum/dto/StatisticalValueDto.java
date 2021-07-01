package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.StatisticalValue;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class StatisticalValueDto {

  @NotNull
  private final String keyword;

  @NotNull
  private final String value;

  private final boolean courseTopic;

  public StatisticalValueDto(final StatisticalValue statisticalValue) {
    this.keyword = statisticalValue.getKeyword();
    this.value = statisticalValue.getValue();
    this.courseTopic = statisticalValue.isCourseTopic();
  }

  public StatisticalValue toEntity() {
    return StatisticalValue.builder()
        .keyword(keyword)
        .value(value)
        .courseTopic(courseTopic)
        .build();
  }
}
