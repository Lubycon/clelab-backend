package com.lubycon.curriculum.domain.curriculum.repository;

import com.lubycon.curriculum.domain.curriculum.domain.Curriculum;
import java.util.List;

public interface CurriculumCustomRepository {

  List<Curriculum> findAllCurriculums();

}
