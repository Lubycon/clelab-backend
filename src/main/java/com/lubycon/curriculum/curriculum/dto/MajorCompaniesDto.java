package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.MajorCompanyFrequency;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MajorCompaniesDto {

  private String title;
  private boolean naver;
  private boolean kakao;
  private boolean line;
  private boolean coupang;
  private boolean woowabros;
  private boolean toss;
  private boolean daangn;
  private boolean yanolja;

  public MajorCompaniesDto(final MajorCompanyFrequency majorCompanyFrequency) {
    this.naver = majorCompanyFrequency.isNaver();
    this.kakao = majorCompanyFrequency.isKakao();
    this.line = majorCompanyFrequency.isLine();
    this.coupang = majorCompanyFrequency.isCoupang();
    this.woowabros = majorCompanyFrequency.isWoowabros();
    this.toss = majorCompanyFrequency.isToss();
    this.daangn = majorCompanyFrequency.isDaangn();
    this.yanolja = majorCompanyFrequency.isYanolja();
  }

  public MajorCompanyFrequency toEntity() {
    return MajorCompanyFrequency.builder()
        .title(title)
        .naver(naver)
        .kakao(kakao)
        .line(line)
        .coupang(coupang)
        .woowabros(woowabros)
        .toss(toss)
        .daangn(daangn)
        .yanolja(yanolja)
        .build();
  }
}
