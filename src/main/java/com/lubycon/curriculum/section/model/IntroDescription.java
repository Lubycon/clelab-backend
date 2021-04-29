package com.lubycon.curriculum.section.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class IntroDescription {

  @Column(name = "description")
  private String description;

  @Column(name = "summary")
  private String summary;

  @Builder
  public IntroDescription(String description, String summary) {
    this.description = description;
    this.summary = summary;
  }
}
