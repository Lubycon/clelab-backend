package com.lubycon.curriculum.domain.section.domain;

import com.lubycon.curriculum.base.domain.BaseTimeEntity;
import com.lubycon.curriculum.domain.section.code.QuizType;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class QuizQuestion extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "type", nullable = false)
  private String type;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "quiz_type", nullable = false)
  private QuizType quizType;

  @Column(name = "message", nullable = false)
  private String message;

  @ManyToOne
  @JoinColumn(name = "quiz_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Section section;

  @OrderBy("order asc")
  @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
  private List<QuizAnswer> answers;
}
