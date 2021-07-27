package com.lubycon.curriculum.curriculum.repository;

import com.lubycon.curriculum.curriculum.domain.Curriculum;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long>,
    CurriculumCustomRepository {

  Optional<Curriculum> findByUrlSlug(String UrlSlug);

}
