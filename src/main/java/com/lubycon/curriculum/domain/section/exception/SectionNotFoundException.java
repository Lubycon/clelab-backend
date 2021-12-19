package com.lubycon.curriculum.domain.section.exception;

import com.lubycon.curriculum.base.error.exception.EntityNotFoundException;

public class SectionNotFoundException extends EntityNotFoundException {

  public SectionNotFoundException(final String message) {
    super(message);
  }
}
