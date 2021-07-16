package com.lubycon.curriculum.email.exception;

import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.base.error.exception.BusinessException;

public class SesSecretNotEqualsException extends BusinessException {

  public SesSecretNotEqualsException(final String input) {
    super(ErrorCode.SES_SECRET_NOT_EQUALS.getMessage() + input,
        ErrorCode.SES_SECRET_NOT_EQUALS);
  }
}
