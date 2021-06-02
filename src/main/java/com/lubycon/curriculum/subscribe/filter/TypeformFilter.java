package com.lubycon.curriculum.subscribe.filter;

import com.lubycon.curriculum.subscribe.exception.TypeFormSecretNotEquals;
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
@WebFilter(urlPatterns = "/subscribe/typeform")
public class TypeformFilter implements Filter {

  @Value("${typeform.secret}")
  private final String secretKey;

  public TypeformFilter(final String secretKey) {
    this.secretKey = secretKey;
  }

  @Override
  public void doFilter(
      final ServletRequest request, final ServletResponse response, final FilterChain chain)
      throws IOException, ServletException {

    final HttpServletRequest httpRequest = (HttpServletRequest) request;
    final String typeFormSignatureValue = httpRequest.getHeader("Typeform-Signature");

    if (!secretKey.equals(typeFormSignatureValue)) {
      throw new TypeFormSecretNotEquals(typeFormSignatureValue);
    }

    chain.doFilter(request, response);
  }
}
