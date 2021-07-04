package com.lubycon.curriculum.subscribe.exception;

import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.base.error.exception.BusinessException;

public class FailedCancelSubscribeException extends BusinessException {

  public FailedCancelSubscribeException() {
    super(ErrorCode.FAILED_CANCEL_SUBSCRIBE);
  }
}
