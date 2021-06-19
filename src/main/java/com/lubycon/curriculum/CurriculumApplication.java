package com.lubycon.curriculum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy
@ServletComponentScan
@SpringBootApplication
public class CurriculumApplication {

  public static void main(final String[] args) {
    SpringApplication.run(CurriculumApplication.class, args);
  }

}
