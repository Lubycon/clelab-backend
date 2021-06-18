package com.lubycon.curriculum.base.service;

import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.base.error.exception.BusinessException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HttpRequestService {

  public String getBody(final String url) {
    try {
      return Unirest
          .get(url)
          .asString()
          .getBody();
    } catch (final UnirestException exception) {
      log.error("{}", exception.getMessage());
      throw new BusinessException(ErrorCode.FAILED_HTTP_REQUEST);
    }
  }

}
