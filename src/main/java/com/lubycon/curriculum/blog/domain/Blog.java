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

  @Column(name = "clelab_pick", nullable = false)
  private boolean clelabPick;

  @Column(name = "order_by", nullable = false)
  private Integer orderBy;

  @Column(name = "writer")
  private String writer;

  @ManyToOne
  @JoinColumn(name = "section_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Section section;

  @Builder
  public Blog(final String title, final String link, final boolean clelabPick,
      final Section section) {
    this.title = title;
    this.link = link;
    this.clelabPick = clelabPick;
    this.section = section;
  }
}
