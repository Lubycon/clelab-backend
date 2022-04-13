package com.lubycon.curriculum.domain.curriculum.dto;

import com.lubycon.curriculum.domain.section.code.QuizType;
import com.lubycon.curriculum.domain.section.domain.QuizQuestion;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QuizResponse {

  private final String question;

  private final QuizType questionType;

  private final List<AnswerResponse> answers;

  @Builder
  public QuizResponse(final String question,
      final QuizType questionType,
      final List<AnswerResponse> answers) {
    this.question = question;
    this.questionType = questionType;
    this.answers = answers;
  }

  public static QuizResponse of(final QuizQuestion question) {
    return QuizResponse.builder()
        .question(question.getMessage())
        .questionType(question.getQuizType())
        .answers(question.getAnswers()
            .stream()
            .map(AnswerResponse::new)
            .collect(Collectors.toList()))
        .build();
  }
}
