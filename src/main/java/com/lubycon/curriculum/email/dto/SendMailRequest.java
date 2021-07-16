package com.lubycon.curriculum.email.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendMailRequest {

  private long templateId;

  private List<String> to;
}
