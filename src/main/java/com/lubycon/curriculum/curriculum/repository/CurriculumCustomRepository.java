package com.lubycon.curriculum.curriculum.repository;

import com.lubycon.curriculum.curriculum.domain.Curriculum;
import java.util.List;

public interface CurriculumCustomRepository {

  List<Curriculum> findAllCurriculums();

}
