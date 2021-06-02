package com.lubycon.curriculum.subscribe.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Setter
@Getter
public class TypeformResponse {

  @NotNull
  private List<TypeformAnswer> answers;

  public String getEmailFromResponse() {
    for (final TypeformAnswer answer : answers) {
      if (answer.getType().equals("email")) {
        return answer.getEmail();
      }
    }

    return "";
  }

}
