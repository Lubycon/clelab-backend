package com.lubycon.curriculum.subscribe.exception;

import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.base.error.exception.EntityNotFoundException;

public class EmailTemplateNotFoundException extends EntityNotFoundException {

  public EmailTemplateNotFoundException() {
    super(ErrorCode.EMAIL_TEMPLATE_NOT_FOUND.getMessage());
  }
}
