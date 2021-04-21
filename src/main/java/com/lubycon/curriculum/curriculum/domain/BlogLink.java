package com.lubycon.curriculum.curriculum.domain;

import com.lubycon.curriculum.base.domain.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "blog_link")
@Getter
@Entity
public class BlogLink extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "link")
  private String link;

  @Builder
  public BlogLink(String title, String link) {
    this.title = title;
    this.link = link;
  }
}
