package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.StatisticalInfo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class StatisticalDto {

  @NotNull
  private final String title;

  @NotNull
  private final String description;

  @NotNull
  private final List<StatisticalValueDto> values;

  public StatisticalDto(final StatisticalInfo statisticalInfo) {
    this.title = statisticalInfo.getTitle();
    this.description = statisticalInfo.getDescription();
    this.values = statisticalInfo.getStatisticalValues()
        .stream()
        .map(StatisticalValueDto::new)
        .collect(Collectors.toList());
  }

  public StatisticalInfo toEntity() {
    return StatisticalInfo.builder()
        .title(title)
        .description(description)
        .statisticalValues(values
            .stream()
            .map(StatisticalValueDto::toEntity)
            .collect(Collectors.toList()))
        .build();
  }
}
