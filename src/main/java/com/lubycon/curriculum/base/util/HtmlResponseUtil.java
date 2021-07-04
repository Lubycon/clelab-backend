package com.lubycon.curriculum.base.util;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HtmlResponseUtil {

  private HtmlResponseUtil() {
  }

  public static void alertAndMove(final String message, final String url)
      throws IOException {
    final HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder
        .getRequestAttributes()).getResponse();

    response.setContentType("text/html; charset=UTF-8");
    final PrintWriter out = response.getWriter();
    out.println("<script>alert('" + message + "'); "
        + "location.replace('" + url + "');</script>");
    out.flush();
  }
}
