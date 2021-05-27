package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.model.IntroDescription;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public class IntroDescriptionResponse {

  @Nullable
  private final String summary;

  @Nullable
  private final String subSummary;

  @Nullable
  private final String header;

  @Nullable
  private final String footer;


  public IntroDescriptionResponse(final IntroDescription intro) {
    this.summary = intro.getSummary();
    this.subSummary = intro.getSubSummary();
    this.header = intro.getHeader();
    this.footer = intro.getFooter();
  }
}
