package com.lubycon.curriculum.curriculum.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SectionsRequest {

  private String title;
  private String description;
  private Integer orderBy;
  private List<SaveBlog> blogs;

}
