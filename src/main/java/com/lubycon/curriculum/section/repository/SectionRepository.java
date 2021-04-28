package com.lubycon.curriculum.section.repository;

import com.lubycon.curriculum.section.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {

}
