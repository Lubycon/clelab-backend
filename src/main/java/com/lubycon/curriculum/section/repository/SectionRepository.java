package com.lubycon.curriculum.section.repository;

import com.lubycon.curriculum.section.domain.Section;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long>, SectionCustomRepository {

  Optional<Section> findByCurriculumIdAndId(long curriculumId, long id);

  Optional<Section> findByCurriculumIdAndOrder(long curriculumId, int order);

}
