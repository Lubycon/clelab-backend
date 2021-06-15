package com.lubycon.curriculum.base.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
  // Common
  INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "Invalid Input Value"),
  METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C002", "Invalid Input Value"),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C003", "Internal Server Error"),
  INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C004", "Invalid Type Value"),
  ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "C005", "Entity Not Found"),
  FAIL_ENUM_BINDING(HttpStatus.BAD_REQUEST, "C006", "Fail Enum Binding"),

  // Subscribe
  TYPEFORM_SECRET_NOT_EQUALS(HttpStatus.UNAUTHORIZED, "S001", "Typeform secret not equals : "),
  FAILED_SEND_MAIL(HttpStatus.INTERNAL_SERVER_ERROR, "S002", "Send mail failed : "),
  SES_SECRET_NOT_EQUALS(HttpStatus.UNAUTHORIZED, "S003", "SES secret not equals : "),
  EMAIL_TEMPLATE_NOT_FOUND(HttpStatus.NOT_FOUND, "S004", "EmailTemplate Not Found");


  private final String code;
  private final String message;
  private final HttpStatus status;

  ErrorCode(final HttpStatus status, final String code, final String message) {
    this.status = status;
    this.message = message;
    this.code = code;
  }
}
