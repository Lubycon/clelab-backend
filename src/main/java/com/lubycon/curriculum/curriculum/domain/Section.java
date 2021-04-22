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
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Section extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
  private List<BlogLink> links;

  @Builder
  public Section(String description) {
    this.description = description;
  }
}
