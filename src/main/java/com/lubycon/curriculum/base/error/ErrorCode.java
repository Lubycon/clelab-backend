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
  FAIL_ENUM_BINDING(HttpStatus.BAD_REQUEST, "C006", "Fail Enum Binding");

  private final String code;
  private final String message;
  private final HttpStatus status;

  ErrorCode(final HttpStatus status, final String code, final String message) {
    this.status = status;
    this.message = message;
    this.code = code;
  }
}
