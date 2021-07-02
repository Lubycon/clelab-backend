package com.lubycon.curriculum.curriculum.domain;

import com.lubycon.curriculum.base.domain.BaseTimeEntity;
import com.lubycon.curriculum.section.domain.IntroSection;
import com.lubycon.curriculum.section.domain.Section;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Curriculum extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "thumbnail", nullable = false)
  private String thumbnail;

  @OneToOne(mappedBy = "curriculum", cascade = CascadeType.ALL)
  private IntroSection introSection;

  @OneToMany(mappedBy = "curriculum", fetch = FetchType.LAZY)
  @OrderBy("order asc")
  private List<Section> sections;

  @Builder
  public Curriculum(final String title, final String description, final String thumbnail,
      final List<Section> sections, final IntroSection introSection) {
    this.title = title;
    this.description = description;
    this.thumbnail = thumbnail;
    this.sections = sections;
    this.introSection = introSection;
    introSection.setCurriculum(this);
  }
}
