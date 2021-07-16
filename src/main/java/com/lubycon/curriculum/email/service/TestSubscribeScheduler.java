package com.lubycon.curriculum.email.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TestSubscribeScheduler {

  private final EmailTesterService emailTesterService;

  @Transactional
  @Scheduled(cron = "0 0 23 * * SUN")
  public void sendEmailToTester() {
    log.info(">>>> Scheduled Start ...");
    emailTesterService.sendToTesters();
  }

}
