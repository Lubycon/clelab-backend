package com.lubycon.curriculum.subscribe.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendMailRequest {

  @NotBlank(message = "메일 제목은 필수 입력 사항입니다.")
  private String subject;

  @NotBlank(message = "메일 본문은 필수 입력 사항입니다.")
  private String body;

  private List<String> to;
}
