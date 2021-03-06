package com.lubycon.curriculum.domain.section.service;

import com.lubycon.curriculum.domain.curriculum.dto.QuizResponse;
import com.lubycon.curriculum.domain.section.domain.Section;
import com.lubycon.curriculum.domain.section.dto.NextSectionResponse;
import com.lubycon.curriculum.domain.section.dto.PrevSectionResponse;
import com.lubycon.curriculum.domain.section.dto.SectionResponse;
import com.lubycon.curriculum.domain.section.exception.SectionNotFoundException;
import com.lubycon.curriculum.domain.section.repository.SectionRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SectionService {

  private final SectionRepository sectionRepository;

  @Transactional(readOnly = true)
  public SectionResponse findSectionBySlug(final String curriculumSlug, final String sectionSlug) {
    final Section section = findBySlug(curriculumSlug, sectionSlug);
    final PrevSectionResponse prevSection = findPrevSection(section.getCurriculum().getId(), section.getOrder());
    final NextSectionResponse nextSection = findNextSection(section.getCurriculum().getId(), section.getOrder());
    final List<QuizResponse> quizzes = section.getQuiz()
        .stream()
        .map(QuizResponse::of)
        .collect(Collectors.toList());

    return SectionResponse.toResponse(section, quizzes, prevSection, nextSection);
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
