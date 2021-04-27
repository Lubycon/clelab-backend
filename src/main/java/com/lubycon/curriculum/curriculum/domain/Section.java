package com.lubycon.curriculum.curriculum.domain;

import com.lubycon.curriculum.base.domain.BaseTimeEntity;
import com.lubycon.curriculum.blog.domain.Blog;
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

  @Column(name = "curriculum_id", updatable = false)
  private Long curriculumId;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
  private List<Blog> links;

  @ManyToOne
  @JoinColumn(name = "curriculum_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Curriculum curriculum;


  @Builder
  public Section(String description) {
    this.description = description;
  }
}
