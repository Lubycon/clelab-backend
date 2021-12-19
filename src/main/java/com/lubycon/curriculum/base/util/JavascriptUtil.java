package com.lubycon.curriculum.base.util;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JavascriptUtil {

  public static final String HTML_CONTENT_TYPE = "text/html; charset=UTF-8";

  public static void alertAndMove(final String message, final String replaceUrl)
      throws IOException {
    final HttpServletResponse response = getHttpServletResponse();
    response.setContentType(HTML_CONTENT_TYPE);

    final PrintWriter out = response.getWriter();
    out.println(getHtml(message, replaceUrl));
    out.flush();
  }

  private static HttpServletResponse getHttpServletResponse() {
    final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
        .getRequestAttributes();

    Assert.notNull(requestAttributes, "requestAttribute must be not null");
    return requestAttributes.getResponse();
  }

  private static String getHtml(final String message, final String url) {
    return String.format("<script>alert('%s'); "
        + "location.replace('%s');</script>", message, url);
  }
}
