package com.lubycon.curriculum.domain.email.dto;

import lombok.Getter;

@Getter
public class EmailDto {

  private final String email;

  public EmailDto(final String email) {
    this.email = email;
  }
}
