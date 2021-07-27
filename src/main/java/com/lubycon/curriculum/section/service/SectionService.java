package com.lubycon.curriculum.section.service;

import com.lubycon.curriculum.section.domain.Section;
import com.lubycon.curriculum.section.dto.NextSectionResponse;
import com.lubycon.curriculum.section.dto.PrevSectionResponse;
import com.lubycon.curriculum.section.dto.SectionResponse;
import com.lubycon.curriculum.section.exception.SectionNotFoundException;
import com.lubycon.curriculum.section.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SectionService {

  private final SectionRepository sectionRepository;

  @Transactional(readOnly = true)
  public SectionResponse findSection(final long curriculumId, final long sectionId) {
    final Section section = findById(curriculumId, sectionId);
    final PrevSectionResponse prevSection = findPrevSection(curriculumId, section.getOrder());
    final NextSectionResponse nextSection = findNextSection(curriculumId, section.getOrder());

    return SectionResponse.toResponse(section, prevSection, nextSection);
  }

  @Transactional(readOnly = true)
  public SectionResponse findSectionBySlug(final String curriculumSlug, final String sectionSlug) {
    final Section section = findBySlug(curriculumSlug, sectionSlug);
    final PrevSectionResponse prevSection = findPrevSection(section.getCurriculum().getId(),
        section.getOrder());
    final NextSectionResponse nextSection = findNextSection(section.getCurriculum().getId(),
        section.getOrder());

    return SectionResponse.toResponse(section, prevSection, nextSection);
  }

  private Section findById(final long curriculumId, final long sectionId) {
    return sectionRepository.findByCurriculumIdAndId(curriculumId, sectionId)
        .orElseThrow(() -> new SectionNotFoundException(sectionId + "에 해당하는 섹션이 없습니다."));
  }

  private Section findBySlug(final String curriculumSlug, final String sectionSlug) {
    return sectionRepository.findSectionBySlug(curriculumSlug, sectionSlug)
        .orElseThrow(() -> new SectionNotFoundException(sectionSlug + "에 해당하는 섹션이 없습니다."));
  }

  private NextSectionResponse findNextSection(final long curriculumId, final int order) {
    return sectionRepository.findByCurriculumIdAndOrder(curriculumId, order + 1)
        .map(NextSectionResponse::fromEntity)
        .orElse(null);
  }

  private PrevSectionResponse findPrevSection(final long curriculumId, final int order) {
    return sectionRepository.findByCurriculumIdAndOrder(curriculumId, order - 1)
        .map(PrevSectionResponse::fromEntity)
        .orElse(null);
  }
}
