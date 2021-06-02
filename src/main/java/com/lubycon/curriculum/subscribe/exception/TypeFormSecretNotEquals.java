package com.lubycon.curriculum.subscribe.exception;

import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.base.error.exception.BusinessException;

public class TypeFormSecretNotEquals extends BusinessException {

  public TypeFormSecretNotEquals(final String input) {
    super(ErrorCode.TYPEFORM_SECRET_NOT_EQUALS.getMessage() + input,
        ErrorCode.TYPEFORM_SECRET_NOT_EQUALS);
  }
}
