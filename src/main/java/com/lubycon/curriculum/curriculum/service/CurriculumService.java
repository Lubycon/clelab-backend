package com.lubycon.curriculum.curriculum.service;

import com.lubycon.curriculum.curriculum.domain.Curriculum;
import com.lubycon.curriculum.curriculum.dto.CurriculumResponse;
import com.lubycon.curriculum.curriculum.repository.CurriculumRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CurriculumService {

  private final CurriculumRepository curriculumRepository;

  public List<CurriculumResponse> getCurriculums() {
    return findAll()
        .stream()
        .map(CurriculumResponse::new)
        .collect(Collectors.toList());
  }

  private List<Curriculum> findAll() {
    return curriculumRepository.findAll();
  }

}
