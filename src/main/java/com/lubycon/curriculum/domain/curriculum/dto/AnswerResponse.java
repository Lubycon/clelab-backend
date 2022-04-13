package com.lubycon.curriculum.domain.curriculum.dto;

import com.lubycon.curriculum.domain.section.domain.QuizAnswer;
import lombok.Getter;

@Getter
public class AnswerResponse {

  private final String message;

  private final boolean answer;

  public AnswerResponse(final QuizAnswer answer) {
    this.message = answer.getMessage();
    this.answer = answer.isAnswer();
  }
}
