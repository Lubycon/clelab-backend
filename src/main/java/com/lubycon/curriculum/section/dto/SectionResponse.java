package com.lubycon.curriculum.section.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionResponse {

  private String title;
  private String description;
  private List<BlogResponse> blogs;
  private NextSectionResponse nextSection;
  private PrevSectionResponse prevSection;
}
