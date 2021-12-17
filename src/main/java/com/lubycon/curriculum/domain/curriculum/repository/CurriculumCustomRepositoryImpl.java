package com.lubycon.curriculum.domain.curriculum.repository;

import com.lubycon.curriculum.domain.curriculum.domain.Curriculum;
import com.lubycon.curriculum.domain.curriculum.domain.QCurriculum;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class CurriculumCustomRepositoryImpl extends QuerydslRepositorySupport implements
    CurriculumCustomRepository {

  public CurriculumCustomRepositoryImpl() {
    super(Curriculum.class);
  }

  @Override
  public List<Curriculum> findAllCurriculums() {
    final QCurriculum curriculum = QCurriculum.curriculum;
    return from(curriculum)
        .orderBy(curriculum.id.desc())
        .where(curriculum.show.isTrue())
        .fetch();
  }
}
