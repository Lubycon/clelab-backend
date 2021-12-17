package com.lubycon.curriculum.domain.curriculum.dto;

import com.lubycon.curriculum.domain.section.domain.MajorCompanyFrequency;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class MajorCompanyFrequencyDto {

  @NotNull
  private final String title;

  @NotNull
  private final MajorCompaniesDto companies;

  public MajorCompanyFrequencyDto(final MajorCompanyFrequency majorCompanyFrequency) {
    this.title = majorCompanyFrequency.getTitle();
    this.companies = new MajorCompaniesDto(majorCompanyFrequency);
  }
}
