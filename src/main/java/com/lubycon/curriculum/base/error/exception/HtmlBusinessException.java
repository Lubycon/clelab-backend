package com.lubycon.curriculum.base.error.exception;

import com.lubycon.curriculum.base.error.ErrorCode;

public class HtmlBusinessException extends BusinessException {

  public HtmlBusinessException(final ErrorCode errorCode) {
    super(errorCode);
  }

}
