package com.lubycon.curriculum.curriculum.service;

import com.lubycon.curriculum.curriculum.dto.CurriculumResponse;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CurriculumService {

  public List<CurriculumResponse> getCurriculums() {
    return Collections.EMPTY_LIST;
  }

}
