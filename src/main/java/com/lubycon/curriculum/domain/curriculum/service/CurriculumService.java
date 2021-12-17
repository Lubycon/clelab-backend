package com.lubycon.curriculum.domain.curriculum.service;

import com.lubycon.curriculum.domain.curriculum.domain.Curriculum;
import com.lubycon.curriculum.domain.curriculum.dto.CurriculumResponse;
import com.lubycon.curriculum.domain.curriculum.dto.CurriculumSectionsResponse;
import com.lubycon.curriculum.domain.curriculum.dto.SaveCurriculums;
import com.lubycon.curriculum.domain.curriculum.exception.CurriculumNotFoundException;
import com.lubycon.curriculum.domain.curriculum.repository.CurriculumRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CurriculumService {

  private final CurriculumRepository curriculumRepository;

  @Transactional(readOnly = true)
  public List<CurriculumResponse> getCurriculums() {
    return findAll()
        .stream()
        .map(CurriculumResponse::new)
        .collect(Collectors.toList());
  }

  @Transactional
  public long saveCurriculum(final SaveCurriculums curriculums) {
    final Curriculum curriculum = curriculums.toEntity();

    final Curriculum savedCurriculum = curriculumRepository.save(curriculum);

    return savedCurriculum.getId();
  }


  @Transactional(readOnly = true)
  public CurriculumSectionsResponse getCoursesSections(final String courseSlug) {
    final Curriculum curriculum = findBySlug(courseSlug);
    return CurriculumSectionsResponse.toResponse(curriculum);
  }


  private List<Curriculum> findAll() {
    return curriculumRepository.findAllCurriculums();
  }

  private Curriculum findById(final long id) {
    return curriculumRepository.findById(id)
        .orElseThrow(() -> new CurriculumNotFoundException(id + "에 해당하는 커리큘럼이 없습니다."));
  }

  private Curriculum findBySlug(final String slug) {
    return curriculumRepository.findByUrlSlug(slug)
        .orElseThrow(() -> new CurriculumNotFoundException(slug + "에 해당하는 커리큘럼이 없습니다."));
  }

}
