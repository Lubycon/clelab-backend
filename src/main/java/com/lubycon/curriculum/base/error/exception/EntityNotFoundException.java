package com.lubycon.curriculum.base.error.exception;

import com.lubycon.curriculum.base.error.ErrorCode;

public class EntityNotFoundException extends BusinessException {

  public EntityNotFoundException(String message) {
    super(message, ErrorCode.ENTITY_NOT_FOUND);
  }
}