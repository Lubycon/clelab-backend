package com.lubycon.curriculum.section.domain;

import com.lubycon.curriculum.curriculum.domain.Curriculum;
import com.lubycon.curriculum.section.model.IntroDescription;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class IntroSection {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "curriculum_id", updatable = false)
  private Long curriculumId;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "pointDescription", column = @Column(name = "point_description")),
      @AttributeOverride(name = "description", column = @Column(name = "description")),
  })
  private IntroDescription description;

  @OneToOne
  @JoinColumn(name = "curriculum_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Curriculum curriculum;
}