package com.lubycon.curriculum.subscribe.dto;

import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubscribeRequest {

  @Email(message = "올바른 이메일을 입력해주세요")
  private String email;

}
