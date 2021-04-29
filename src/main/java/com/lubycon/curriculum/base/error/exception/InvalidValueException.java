package com.lubycon.curriculum.base.error.exception;

import com.lubycon.curriculum.base.error.ErrorCode;

public class InvalidValueException extends BusinessException {

  public InvalidValueException(String value) {
    super(value, ErrorCode.INVALID_INPUT_VALUE);
  }

  public InvalidValueException(String value, ErrorCode errorCode) {
    super(value, errorCode);
  }
}