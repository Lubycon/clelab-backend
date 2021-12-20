package com.lubycon.curriculum.domain.section.repository;

import com.lubycon.curriculum.domain.section.domain.Section;
import java.util.Optional;

public interface SectionCustomRepository {

  Optional<Section> findSectionBySlug(String curriculumSlug, String sectionSlug);
}
