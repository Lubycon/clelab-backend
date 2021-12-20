package com.lubycon.curriculum.domain.curriculum.api;

import com.lubycon.curriculum.domain.curriculum.dto.AddCurriculumsRequest;
import com.lubycon.curriculum.domain.curriculum.dto.CurriculumResponse;
import com.lubycon.curriculum.domain.curriculum.service.CurriculumService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CurriculumApi {

  private final CurriculumService curriculumService;

  @GetMapping("/curriculums")
  public ResponseEntity<List<CurriculumResponse>> getAllCurriculums() {

    return ResponseEntity.ok()
        .body(curriculumService.getCurriculums());
  }

  @PostMapping("/curriculums")
  public ResponseEntity<Long> addCurriculums(
      @RequestBody @Valid final AddCurriculumsRequest curriculumsRequest) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(curriculumService.saveCurriculum(curriculumsRequest.toServiceDto()));
  }
}
