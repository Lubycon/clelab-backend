package com.lubycon.curriculum.curriculum.dto;

import com.lubycon.curriculum.section.domain.MajorCompanyFrequency;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class MajorCompanyFrequencyResponse {

  @NotNull
  private final String title;

  @NotNull
  private final MajorCompaniesResponse companies;

  public MajorCompanyFrequencyResponse(final MajorCompanyFrequency majorCompanyFrequency) {
    this.title = majorCompanyFrequency.getTitle();
    this.companies = new MajorCompaniesResponse(majorCompanyFrequency);
  }
}
