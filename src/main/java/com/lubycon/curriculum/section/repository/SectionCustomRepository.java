package com.lubycon.curriculum.section.repository;

import com.lubycon.curriculum.section.domain.Section;
import java.util.Optional;

public interface SectionCustomRepository {

  Optional<Section> findSectionBySlug(String curriculumSlug, String sectionSlug);
}
