package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.blog.domain.Blog;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveBlog {

  private String title;
  private String url;

  public SaveBlog(final String title, final String url) {
    this.title = title;
    this.url = url;
  }

  public Blog toEntity() {
    return Blog.builder()
        .title(title)
        .link(url)
        .build();
  }
}
