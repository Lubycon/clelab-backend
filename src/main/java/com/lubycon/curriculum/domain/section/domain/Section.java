package com.lubycon.curriculum.domain.section.domain;

import com.lubycon.curriculum.base.domain.BaseTimeEntity;
import com.lubycon.curriculum.domain.blog.domain.Blog;
import com.lubycon.curriculum.domain.curriculum.domain.Curriculum;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "order_by", nullable = false)
  private Integer order;

  @Column(name = "is_hide", nullable = false, columnDefinition = "boolean default false")
  private boolean hide;

  @Column(name = "url_slug")
  private String urlSlug;

  @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
  @OrderBy("orderBy ASC")
  private List<Blog> blogs;

  @ManyToOne
  @JoinColumn(name = "curriculum_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Curriculum curriculum;

  @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
  private List<QuizQuestion> quiz;

  @Builder
  public Section(final String title, final String description, final Integer order,
      final Curriculum curriculum, final List<Blog> blogs) {
    this.title = title;
    this.description = description;
    this.order = order;
    this.curriculum = curriculum;
    this.blogs = blogs;
  }
}
