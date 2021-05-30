package com.lubycon.curriculum.curriculum.api;

import com.lubycon.curriculum.curriculum.dto.CurriculumResponse;
import com.lubycon.curriculum.curriculum.service.CurriculumService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CurriculumApi {

  private final CurriculumService curriculumService;

  @GetMapping(value = {"/v1/curriculums", "/curriculums"})
  public ResponseEntity<List<CurriculumResponse>> getAllCurriculums() {

    return ResponseEntity.ok()
        .body(curriculumService.getCurriculums());
  }
}
