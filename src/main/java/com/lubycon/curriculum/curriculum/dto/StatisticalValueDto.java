package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.StatisticalValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
@Setter
@Getter
public class StatisticalValueDto {

  @NotNull
  private String keyword;

  @NotNull
  private String value;

  private boolean courseTopic;

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
