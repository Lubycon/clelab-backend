package com.lubycon.curriculum.subscribe.exception;

import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.base.error.exception.EntityNotFoundException;

public class EmailTemplateNotFound extends EntityNotFoundException {

  public EmailTemplateNotFound() {
    super(ErrorCode.EMAIL_TEMPLATE_NOT_FOUND.getMessage());
  }
}
