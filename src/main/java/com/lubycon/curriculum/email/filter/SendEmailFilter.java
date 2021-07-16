package com.lubycon.curriculum.email.filter;

import com.lubycon.curriculum.email.exception.SesSecretNotEqualsException;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@WebFilter(urlPatterns = "/mail/*")
public class SendEmailFilter implements Filter {

  @Value("${aws.ses.custom-secret}")
  private String secretKey;

  public void setSecretKey(final String secretKey) {
    this.secretKey = secretKey;
  }

  @Override
  public void doFilter(
      final ServletRequest request, final ServletResponse response, final FilterChain chain)
      throws IOException, ServletException {

    final HttpServletRequest httpRequest = (HttpServletRequest) request;
    final String sesSecretHeader = httpRequest.getHeader("SES-Secret");

    if (!sesSecretHeader.equals(secretKey)) {
      throw new SesSecretNotEqualsException(sesSecretHeader);
    }

    chain.doFilter(request, response);
  }
}
