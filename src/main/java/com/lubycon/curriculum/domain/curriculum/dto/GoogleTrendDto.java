package com.lubycon.curriculum.domain.curriculum.dto;

import com.lubycon.curriculum.domain.section.domain.GoogleTrend;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class GoogleTrendDto {

  @NotNull
  private final String title;

  @NotNull
  private final String csvHtml;

  public GoogleTrendDto(final GoogleTrend googleTrend) {
    this.title = googleTrend.getTitle();
    this.csvHtml = googleTrend.getCsvHtml();
  }
}
