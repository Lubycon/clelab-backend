package com.lubycon.curriculum.curriculum.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogRequest {

  private String title;
  private String url;

  public BlogRequest(final String title, final String url) {
    this.title = title;
    this.url = url;
  }

  public SaveBlog toServiceDto() {
    return new SaveBlog(title, url);
  }

}
