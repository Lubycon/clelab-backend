package com.lubycon.curriculum.section.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class IntroDescription {

  @Column(name = "description")
  private String description;

  @Column(name = "point_description")
  private String pointDescription;

}
