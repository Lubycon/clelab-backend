package com.lubycon.curriculum.domain.section.domain;

import com.lubycon.curriculum.base.domain.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class QuizData extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "message", nullable = false)
  private String message;

  @Column(name = "is_answer", nullable = false)
  private boolean answer;

  @Column(name = "order_by", nullable = false)
  private Integer orderBy;

  @ManyToOne
  @JoinColumn(name = "section_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Section section;

}
