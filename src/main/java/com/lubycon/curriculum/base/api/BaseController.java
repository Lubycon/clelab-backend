package com.lubycon.curriculum.base.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

  @RequestMapping("/")
  public String health() {
    return "OK";
  }

}
