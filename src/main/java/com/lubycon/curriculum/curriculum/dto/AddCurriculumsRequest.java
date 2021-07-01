package com.lubycon.curriculum.curriculum.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCurriculumsRequest {

  private String title;
  private String description;
  private String thumbnail;
  private List<SectionsRequest> sections;
  
}
