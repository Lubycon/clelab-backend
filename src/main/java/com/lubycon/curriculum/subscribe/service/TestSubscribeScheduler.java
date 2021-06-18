package com.lubycon.curriculum.subscribe.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Profile("qa")
@Service
public class TestSubscribeScheduler {

  private final EmailTesterService emailTesterService;

  @Transactional
  @Scheduled(cron = "0 0 14 * * SUN")
  public void sendEmailToTester() {
    log.info(">>>> Scheduled Start ...");
    emailTesterService.sendToTesters();
  }

}
