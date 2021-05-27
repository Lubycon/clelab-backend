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
import lombok.Builder;
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

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "summary", column = @Column(name = "summary")),
      @AttributeOverride(name = "subSummary", column = @Column(name = "sub_summary")),
      @AttributeOverride(name = "description", column = @Column(name = "description")), //FIXME: 삭제
      @AttributeOverride(name = "header", column = @Column(name = "header")),
      @AttributeOverride(name = "footer", column = @Column(name = "footer")),
  })
  private IntroDescription description;

  @OneToOne
  @JoinColumn(name = "curriculum_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Curriculum curriculum;

  @OneToOne
  @JoinColumn(name = "major_company_frequency_id", insertable = false, updatable = false)
  private MajorCompanyFrequency majorCompanyFrequency;

  @OneToOne
  @JoinColumn(name = "google_trend_id", insertable = false, updatable = false)
  private GoogleTrend googleTrend;

  @OneToOne
  @JoinColumn(name = "stack_overflow_trend_id", insertable = false, updatable = false)
  private StackOverflowTrend stackOverflowTrend;

  @Builder
  public IntroSection(final IntroDescription description,
      final Curriculum curriculum,
      final MajorCompanyFrequency majorCompanyFrequency,
      final GoogleTrend googleTrend) {
    this.description = description;
    this.curriculum = curriculum;
    this.majorCompanyFrequency = majorCompanyFrequency;
    this.googleTrend = googleTrend;
  }
}
