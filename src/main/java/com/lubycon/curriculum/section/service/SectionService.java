package com.lubycon.curriculum.section.service;

import com.lubycon.curriculum.section.domain.Section;
import com.lubycon.curriculum.section.dto.BlogResponse;
import com.lubycon.curriculum.section.dto.NextSectionResponse;
import com.lubycon.curriculum.section.dto.PrevSectionResponse;
import com.lubycon.curriculum.section.dto.SectionResponse;
import com.lubycon.curriculum.section.repository.SectionRepository;
import java.util.stream.Collectors;
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

    return SectionResponse.builder()
        .title(section.getTitle())
        .description(section.getDescription())
        .order(section.getOrder())
        .blogs(section.getBlogs().stream()
            .map(BlogResponse::new)
            .collect(Collectors.toList()))
        .prevSection(prevSection)
        .nextSection(nextSection)
        .build();
  }

  private Section findById(final long curriculumId, final long sectionId) {
    return sectionRepository.findByCurriculumIdAndId(curriculumId, sectionId)
        .orElseThrow(RuntimeException::new); // FIXME: 예외 바꾸기
  }

  private NextSectionResponse findNextSection(final long curriculumId, final int order) {
    return sectionRepository.findByCurriculumIdAndOrder(curriculumId, order + 1)
        .map(NextSectionResponse::fromEntity)
        .orElse(NextSectionResponse.empty());
  }

  private PrevSectionResponse findPrevSection(final long curriculumId, final int order) {
    return sectionRepository.findByCurriculumIdAndOrder(curriculumId, order - 1)
        .map(PrevSectionResponse::fromEntity)
        .orElse(PrevSectionResponse.empty());
  }
}
