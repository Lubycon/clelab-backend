package com.lubycon.curriculum.domain.email.service;

import com.lubycon.curriculum.base.service.HttpRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscribeAuthService {

  @Value("${aws.ses.greeting-url}")
  private String greetingUrl;

  @Value("${domain}")
  private String domain;

  private final EmailService emailService;
  private final HttpRequestService httpRequestService;

  private final static String SUBJECT = "인증을 완료해주세요!";

  public void sendSubscribeMail(final String email, final String authCode) {
    final String content = getGreetingMailBody(email, authCode);
    emailService.sendMail(email, SUBJECT, content);
  }

  public String getGreetingMailBody(final String email, final String authCode) {
    return httpRequestService.getBody(greetingUrl)
        .replace("{name}", email)
        .replace("{url}", domain + "/subscribe/regist/" + email + "/" + authCode);
  }

}
