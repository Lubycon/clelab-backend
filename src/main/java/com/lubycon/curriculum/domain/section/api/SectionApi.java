package com.lubycon.curriculum.domain.section.api;

import com.lubycon.curriculum.domain.curriculum.dto.CurriculumSectionsResponse;
import com.lubycon.curriculum.domain.curriculum.service.CurriculumService;
import com.lubycon.curriculum.domain.section.dto.SectionResponse;
import com.lubycon.curriculum.domain.section.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SectionApi {

  private final CurriculumService curriculumService;
  private final SectionService sectionService;

  @GetMapping("/courses/{courseSlug}/sections")
  public ResponseEntity<CurriculumSectionsResponse> getAllSectionsBySlug(
      @PathVariable final String courseSlug) {

    return ResponseEntity.ok()
        .body(curriculumService.getCoursesSections(courseSlug));
  }

  @GetMapping("/courses/{courseSlug}/sections/{sectionSlug}")
  public ResponseEntity<SectionResponse> getSectionBySlug(
      @PathVariable final String courseSlug, @PathVariable final String sectionSlug) {

    return ResponseEntity.ok()
        .body(sectionService.findSectionBySlug(courseSlug, sectionSlug));
  }

}
