package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.StackOverflowTrend;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class StackOverflowTrendDto {

  @NotNull
  private final String title;

  @NotNull
  private final String description;

  @NotNull
  private final String imagePath;

  public StackOverflowTrendDto(final StackOverflowTrend stackOverflowTrend) {
    this.title = stackOverflowTrend.getTitle();
    this.description = stackOverflowTrend.getDescription();
    this.imagePath = stackOverflowTrend.getImagePath();
  }

  public StackOverflowTrend toEntity() {
    return StackOverflowTrend.builder()
        .title(title)
        .description(description)
        .imagePath(imagePath)
        .build();
  }
}
