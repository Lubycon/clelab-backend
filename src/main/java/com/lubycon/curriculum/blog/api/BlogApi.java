package com.lubycon.curriculum.blog.api;

import com.lubycon.curriculum.blog.service.BlogService;
import com.lubycon.curriculum.section.dto.BlogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApi {

  private final BlogService blogService;

  @PutMapping("/blogs/{blogId}/clap")
  public ResponseEntity<BlogResponse> clap(@PathVariable final long blogId) {
    final BlogResponse response = blogService.clap(blogId);

    return ResponseEntity.ok()
        .body(response);
  }
}
