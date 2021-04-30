package com.lubycon.curriculum.section.api;

import com.lubycon.curriculum.section.dto.SectionResponse;
import com.lubycon.curriculum.section.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SectionApi {

  private final SectionService sectionService;

  @GetMapping("/curriculums/{curriculumId}/sections/{order}")
  public ResponseEntity<SectionResponse> getSection(
      @PathVariable long curriculumId, @PathVariable int order) {

    return ResponseEntity.ok()
        .body(sectionService.findSection(curriculumId, order));
  }
}
