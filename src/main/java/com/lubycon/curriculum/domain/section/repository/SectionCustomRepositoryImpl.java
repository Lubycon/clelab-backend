package com.lubycon.curriculum.domain.section.repository;

import com.lubycon.curriculum.domain.curriculum.domain.QCurriculum;
import com.lubycon.curriculum.domain.section.domain.QSection;
import com.lubycon.curriculum.domain.section.domain.Section;
import java.util.Optional;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class SectionCustomRepositoryImpl extends QuerydslRepositorySupport implements
    SectionCustomRepository {

  public SectionCustomRepositoryImpl() {
    super(Section.class);
  }

  @Override
  public Optional<Section> findSectionBySlug(final String curriculumSlug,
      final String sectionSlug) {
    final QCurriculum curriculum = QCurriculum.curriculum;
    final QSection section = QSection.section;

    return Optional.ofNullable(from(section)
        .where(curriculum.urlSlug.eq(curriculumSlug).and(section.urlSlug.eq(sectionSlug)))
        .fetchFirst());
  }
}
