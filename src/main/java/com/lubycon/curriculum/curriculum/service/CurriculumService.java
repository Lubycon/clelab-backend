package com.lubycon.curriculum.curriculum.service;

import com.lubycon.curriculum.curriculum.domain.Curriculum;
import com.lubycon.curriculum.curriculum.dto.CurriculumResponse;
import com.lubycon.curriculum.curriculum.dto.CurriculumSectionsResponse;
import com.lubycon.curriculum.curriculum.dto.SaveCurriculums;
import com.lubycon.curriculum.curriculum.dto.v2.CurriculumSectionsResponseV2;
import com.lubycon.curriculum.curriculum.exception.CurriculumNotFoundException;
import com.lubycon.curriculum.curriculum.repository.CurriculumRepository;
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

  public long saveCurriculum(final SaveCurriculums curriculums) {
    return 0;
  }

  @Transactional(readOnly = true)
  public CurriculumSectionsResponse getCurriculumSections(final long curriculumId) {
    final Curriculum curriculum = findById(curriculumId);
    return CurriculumSectionsResponse.toResponse(curriculum);
  }

  @Transactional(readOnly = true)
  public CurriculumSectionsResponseV2 getCurriculumSectionsV2(final long curriculumId) {
    final Curriculum curriculum = findById(curriculumId);
    return CurriculumSectionsResponseV2.toResponse(curriculum);
  }


  private List<Curriculum> findAll() {
    return curriculumRepository.findByOrderByIdDesc();
  }

  private Curriculum findById(final long id) {
    return curriculumRepository.findById(id)
        .orElseThrow(() -> new CurriculumNotFoundException(id + "에 해당하는 커리큘럼이 없습니다."));
  }

}
