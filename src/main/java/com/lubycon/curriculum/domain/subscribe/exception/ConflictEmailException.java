package com.lubycon.curriculum.domain.subscribe.exception;


import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.base.error.exception.BusinessException;

public class ConflictEmailException extends BusinessException {

  public ConflictEmailException() {
    super(ErrorCode.CONFLICT_EMAIL);
  }
}
