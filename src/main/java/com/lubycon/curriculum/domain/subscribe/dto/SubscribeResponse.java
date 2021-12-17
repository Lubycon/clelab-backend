package com.lubycon.curriculum.domain.subscribe.dto;

import lombok.Getter;

@Getter
public class SubscribeResponse {

  private final String email;

  public SubscribeResponse(final String email) {
    this.email = email;
  }
}
