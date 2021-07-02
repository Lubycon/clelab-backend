package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.StackOverflowTrend;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
@Setter
@Getter
public class StackOverflowTrendDto {

  @NotNull
  private String title;

  @NotNull
  private String description;

  @NotNull
  private String imagePath;

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
