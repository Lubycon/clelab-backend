package com.lubycon.curriculum.subscribe.exception;

import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.base.error.exception.HtmlBusinessException;

public class FailedCancelSubscribeException extends HtmlBusinessException {

  public FailedCancelSubscribeException() {
    super(ErrorCode.FAILED_CANCEL_SUBSCRIBE);
  }
}
