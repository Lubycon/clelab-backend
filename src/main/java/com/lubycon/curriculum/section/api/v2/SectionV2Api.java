package com.lubycon.curriculum.section.api.v2;

import com.lubycon.curriculum.curriculum.dto.v2.CurriculumSectionsResponseV2;
import com.lubycon.curriculum.curriculum.service.CurriculumService;
import com.lubycon.curriculum.section.dto.SectionResponse;
import com.lubycon.curriculum.section.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SectionV2Api {

  private final CurriculumService curriculumService;
  private final SectionService sectionService;

  @GetMapping(value = {"/v2/curriculums/{curriculumId}/sections",
      "/curriculums/{curriculumId}/sections"})
  public ResponseEntity<CurriculumSectionsResponseV2> getAllSections(
      @PathVariable final long curriculumId) {

    return ResponseEntity.ok()
        .body(curriculumService.getCurriculumSectionsV2(curriculumId));
  }

  @GetMapping(value = {"/v2/courses/{courseSlug}/sections", "/courses/{courseSlug}/sections"})
  public ResponseEntity<CurriculumSectionsResponseV2> getAllSectionsBySlug(
      @PathVariable final String courseSlug) {

    return ResponseEntity.ok()
        .body(curriculumService.getCoursesSectionsV2(courseSlug));
  }

  @GetMapping(value = {"/v2/curriculums/{curriculumId}/sections/{sectionId}",
      "/curriculums/{curriculumId}/sections/{sectionId}"})
  public ResponseEntity<SectionResponse> getSection(
      @PathVariable final long curriculumId, @PathVariable final long sectionId) {

    return ResponseEntity.ok()
        .body(sectionService.findSection(curriculumId, sectionId));
  }

  @GetMapping(value = {"/v2/courses/{courseSlug}/sections/{sectionSlug}",
      "/courses/{courseSlug}/sections/{sectionSlug}"})
  public ResponseEntity<SectionResponse> getSectionBySlug(
      @PathVariable final String courseSlug, @PathVariable final String sectionSlug) {

    return ResponseEntity.ok()
        .body(sectionService.findSectionBySlug(courseSlug, sectionSlug));
  }

}
