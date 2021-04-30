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
  public SectionResponse findSection(long curriculumId, int order) {
    Section section = findById(curriculumId, order);
    PrevSectionResponse prevSection = findPrevSection(curriculumId, order);
    NextSectionResponse nextSection = findNextSection(curriculumId, order);

    return SectionResponse.builder()
        .title(section.getTitle())
        .description(section.getDescription())
        .blogs(section.getBlogs().stream()
            .map(BlogResponse::new)
            .collect(Collectors.toList()))
        .prevSection(prevSection)
        .nextSection(nextSection)
        .build();
  }

  private Section findById(long curriculumId, int order) {
    return sectionRepository.findByCurriculumIdAndOrder(curriculumId, order)
        .orElseThrow(RuntimeException::new); // FIXME: 예외 바꾸기
  }

  private NextSectionResponse findNextSection(long curriculumId, int order) {
    return sectionRepository.findByCurriculumIdAndOrder(curriculumId, order + 1)
        .map(NextSectionResponse::fromEntity)
        .orElse(null);
  }

  private PrevSectionResponse findPrevSection(long curriculumId, int order) {
    return sectionRepository.findByCurriculumIdAndOrder(curriculumId, order - 1)
        .map(PrevSectionResponse::fromEntity)
        .orElse(null);
  }
}
