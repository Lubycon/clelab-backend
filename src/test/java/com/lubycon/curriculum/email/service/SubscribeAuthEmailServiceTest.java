package com.lubycon.curriculum.email.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class SubscribeAuthEmailServiceTest {

  @Autowired
  SubscribeAuthEmailService subscribeAuthEmailService;

  @DisplayName("메일 템플릿이 정상적인지 확인한다.")
  @Test
  public void subscribeMailContentTest() {
    // when
    final String testEmail = "test@email.com";
    final String content = subscribeAuthEmailService.getGreetingMailBody(testEmail, "TEST");

    // then
    assertThat(content).contains("안녕하세요, " + testEmail + "님");
    assertThat(content).contains("아래 버튼을 눌러 인증을 완료해주세요.");
  }

}