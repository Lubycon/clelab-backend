package com.lubycon.curriculum.subscribe.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Setter
@Getter
public class TypeformAnswer {

  @NotNull
  private String type;

  @Nullable
  private String email;

}
