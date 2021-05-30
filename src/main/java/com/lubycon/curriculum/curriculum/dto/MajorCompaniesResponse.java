package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.MajorCompanyFrequency;
import lombok.Getter;

@Getter
public class MajorCompaniesResponse {

  private final boolean naver;
  private final boolean kakao;
  private final boolean line;
  private final boolean coupang;
  private final boolean woowabros;
  private final boolean toss;
  private final boolean daangn;
  private final boolean yanolja;

  public MajorCompaniesResponse(final MajorCompanyFrequency majorCompanyFrequency) {
    this.naver = majorCompanyFrequency.isNaver();
    this.kakao = majorCompanyFrequency.isKakao();
    this.line = majorCompanyFrequency.isLine();
    this.coupang = majorCompanyFrequency.isCoupang();
    this.woowabros = majorCompanyFrequency.isWoowabros();
    this.toss = majorCompanyFrequency.isToss();
    this.daangn = majorCompanyFrequency.isDaangn();
    this.yanolja = majorCompanyFrequency.isYanolja();
  }
}
