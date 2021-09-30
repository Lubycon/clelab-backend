package com.lubycon.curriculum.blog.exception;

import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.base.error.exception.EntityNotFoundException;

public class BlogNotFoundException extends EntityNotFoundException {

  public BlogNotFoundException(final String message) {
    super(message);
  }

  public BlogNotFoundException() {
    super(ErrorCode.ENTITY_NOT_FOUND.getMessage());
  }
}
