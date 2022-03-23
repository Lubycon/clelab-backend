package com.lubycon.curriculum.domain.section.repository;

import com.lubycon.curriculum.domain.section.domain.QuizData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDataRepository extends JpaRepository<QuizData, Long> {
  
}
