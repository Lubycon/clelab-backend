package com.lubycon.curriculum.blog.domain;

import com.lubycon.curriculum.base.domain.BaseTimeEntity;
import com.lubycon.curriculum.curriculum.domain.Section;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Blog extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "section_id")
  private Long sectionId;

  @Column(name = "title")
  private String title;

  @Column(name = "link")
  private String link;

  @ManyToOne
  @JoinColumn(name = "section_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Section section;

  @Builder
  public Blog(Long sectionId, String title, String link) {
    this.sectionId = sectionId;
    this.title = title;
    this.link = link;
  }
}
