package com.lubycon.curriculum.curriculum.api;

import com.lubycon.curriculum.curriculum.dto.AddCurriculumsRequest;
import com.lubycon.curriculum.curriculum.dto.CurriculumResponse;
import com.lubycon.curriculum.curriculum.service.CurriculumService;
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

  @GetMapping(value = {"/v2/curriculums", "/v1/curriculums", "/curriculums"})
  public ResponseEntity<List<CurriculumResponse>> getAllCurriculums() {

    return ResponseEntity.ok()
        .body(curriculumService.getCurriculums());
  }

  @PostMapping(value = {"/v2/curriculums", "/v1/curriculums", "/curriculums"})
  public ResponseEntity<Long> addCurriculums(
      @RequestBody @Valid final AddCurriculumsRequest curriculumsRequest) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(curriculumService.saveCurriculum(curriculumsRequest.toServiceDto()));
  }
}
