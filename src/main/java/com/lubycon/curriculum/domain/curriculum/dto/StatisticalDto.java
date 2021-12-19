package com.lubycon.curriculum.domain.curriculum.dto;

import com.lubycon.curriculum.domain.section.domain.StatisticalInfo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
@Setter
@Getter
public class StatisticalDto {

  @NotNull
  private String title;

  @NotNull
  private String description;

  @NotNull
  private List<StatisticalValueDto> values;

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
