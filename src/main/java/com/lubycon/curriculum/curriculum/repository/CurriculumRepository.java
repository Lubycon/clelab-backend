package com.lubycon.curriculum.curriculum.repository;

import com.lubycon.curriculum.curriculum.domain.Curriculum;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long>,
    CurriculumCustomRepository {

  List<Curriculum> findByOrderByIdDesc();

}
