package com.lubycon.curriculum.subscribe.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubscribeRequest {

  @NotBlank
  @Email(message = "올바른 이메일을 입력해주세요")
  private String email;

}
