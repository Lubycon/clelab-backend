package com.lubycon.curriculum.section.service;

import com.lubycon.curriculum.section.dto.SectionResponse;
import com.lubycon.curriculum.section.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SectionService {

  private final SectionRepository sectionRepository;

  @Transactional(readOnly = true)
  public SectionResponse findSection(long curriculumId, long sectionId) {
    return null;
  }

}
