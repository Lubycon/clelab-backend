package com.lubycon.curriculum.subscribe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TypeformSubscribeRequest {

  @JsonProperty("form_response")
  private TypeformResponse formResponse;

  public String getEmail() {
    return formResponse.getEmailFromResponse();
  }
}
