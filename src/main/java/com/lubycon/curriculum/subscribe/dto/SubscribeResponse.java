package com.lubycon.curriculum.subscribe.dto;

import com.lubycon.curriculum.subscribe.domain.Email;
import lombok.Getter;

@Getter
public class SubscribeResponse {

  private final String email;

  public SubscribeResponse(final Email email) {
    this.email = email.getEmail();
  }
}
