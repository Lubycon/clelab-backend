package com.lubycon.curriculum.base.config;

import com.google.common.base.Joiner;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class LogConfig {

  @Around("within(com.lubycon.curriculum.*.api.*) && !@annotation(com.lubycon.curriculum.base.annotation.NoLogging)")
  public Object logging(final ProceedingJoinPoint pjp) throws Throwable {
    final String params = getRequestParams();

    log.info("-----------> Request : {}({}) = {}",
        pjp.getSignature().getDeclaringTypeName(),
        pjp.getSignature().getName(), params);

    final Object result = pjp.proceed();

    log.info("-----------> Response : {}({}) = {}",
        pjp.getSignature().getDeclaringTypeName(),
        pjp.getSignature().getName(), result);

    return result;
  }

  private String paramMapToString(final Map<String, String[]> paramMap) {
    return paramMap.entrySet().stream()
        .map(entry -> String.format("%s -> (%s)",
            entry.getKey(), Joiner.on(",").join(entry.getValue())))
        .collect(Collectors.joining(", "));
  }

  private String getRequestParams() {

    String params = "none";

    final RequestAttributes requestAttributes = RequestContextHolder
        .getRequestAttributes();

    if (requestAttributes != null) {
      final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
          .getRequestAttributes()).getRequest();

      final Map<String, String[]> paramMap = request.getParameterMap();
      if (!paramMap.isEmpty()) {
        params = " [" + paramMapToString(paramMap) + "]";
      }
    }

    return params;

  }
}
