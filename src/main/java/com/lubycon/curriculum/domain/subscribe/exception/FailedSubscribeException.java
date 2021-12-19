package com.lubycon.curriculum.domain.subscribe.exception;

import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.base.error.exception.HtmlBusinessException;

public class FailedSubscribeException extends HtmlBusinessException {

  public FailedSubscribeException() {
    super(ErrorCode.FAILED_SUBSCRIBE);
  }
}
