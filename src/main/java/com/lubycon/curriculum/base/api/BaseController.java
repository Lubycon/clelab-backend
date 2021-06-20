package com.lubycon.curriculum.base.api;

import com.lubycon.curriculum.base.annotation.NoLogging;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

  @NoLogging
  @RequestMapping("/")
  public String health() {
    return "OK";
  }

}
