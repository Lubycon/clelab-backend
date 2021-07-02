package com.lubycon.curriculum.section.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MajorCompanyFrequency {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "naver", nullable = false)
  private boolean naver;

  @Column(name = "kakao", nullable = false)
  private boolean kakao;

  @Column(name = "line", nullable = false)
  private boolean line;

  @Column(name = "coupang", nullable = false)
  private boolean coupang;

  @Column(name = "woowabros", nullable = false)
  private boolean woowabros;

  @Column(name = "toss", nullable = false)
  private boolean toss;

  @Column(name = "daangn", nullable = false)
  private boolean daangn;

  @Column(name = "yanolja", nullable = false)
  private boolean yanolja;

  @Builder
  public MajorCompanyFrequency(
      final String title, final boolean naver, final boolean kakao, final boolean line,
      final boolean coupang, final boolean woowabros, final boolean toss, final boolean daangn, final boolean yanolja) {
    this.title = title;
    this.naver = naver;
    this.kakao = kakao;
    this.line = line;
    this.coupang = coupang;
    this.woowabros = woowabros;
    this.toss = toss;
    this.daangn = daangn;
    this.yanolja = yanolja;
  }
}
