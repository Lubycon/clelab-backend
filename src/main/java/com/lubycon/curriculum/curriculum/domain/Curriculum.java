package com.lubycon.curriculum.curriculum.domain;

import com.lubycon.curriculum.base.domain.BaseTimeEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
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

  @OneToOne(mappedBy = "curriculum", fetch = FetchType.LAZY)
  private IntroSection introSection;

  @OneToMany(mappedBy = "curriculum", fetch = FetchType.LAZY)
  private List<Section> sections;
}
