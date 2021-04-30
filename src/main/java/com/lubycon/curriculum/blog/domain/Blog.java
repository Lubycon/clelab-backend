package com.lubycon.curriculum.blog.domain;

import com.lubycon.curriculum.base.domain.BaseTimeEntity;
import com.lubycon.curriculum.section.domain.Section;
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

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "link", nullable = false)
  private String link;

  @ManyToOne
  @JoinColumn(name = "section_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Section section;

  @Builder
  public Blog(String title, String link, Section section) {
    this.title = title;
    this.link = link;
    this.section = section;
  }
}
