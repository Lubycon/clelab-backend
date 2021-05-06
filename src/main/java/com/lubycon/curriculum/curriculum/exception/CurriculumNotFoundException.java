package com.lubycon.curriculum.curriculum.exception;

import com.lubycon.curriculum.base.error.exception.EntityNotFoundException;

public class CurriculumNotFoundException extends EntityNotFoundException {

  public CurriculumNotFoundException(final String message) {
    super(message);
  }
}
