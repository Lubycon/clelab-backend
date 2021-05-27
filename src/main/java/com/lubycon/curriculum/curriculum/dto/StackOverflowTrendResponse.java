package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.StackOverflowTrend;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class StackOverflowTrendResponse {

  @NotNull
  private final String title;

  @NotNull
  private final String description;

  @NotNull
  private final String imagePath;

  public StackOverflowTrendResponse(final StackOverflowTrend stackOverflowTrend) {
    this.title = stackOverflowTrend.getTitle();
    this.description = stackOverflowTrend.getDescription();
    this.imagePath = stackOverflowTrend.getImagePath();
  }
}
