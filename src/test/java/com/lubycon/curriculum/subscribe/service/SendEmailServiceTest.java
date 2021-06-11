package com.lubycon.curriculum.subscribe.service;

import static org.mockito.Mockito.mock;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.lubycon.curriculum.subscribe.dto.EmailSenderDto;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class SendEmailServiceTest {

  @Autowired
  SendEmailService sendEmailService;

  @DisplayName("이메일 전송을 통해 사용자는 이메일을 받을 수 있다.")
  @Test
  public void getSectionTest() {
    // when
    final String subject = "제목";
    final String body = "<h1>만나서 반가워용 ^_^</h1>";
    final List<String> to = Arrays.asList("success@simulator.amazonses.com");

    final AmazonSimpleEmailService emailService = mock(AmazonSimpleEmailService.class);

    final EmailSenderDto senderDto = EmailSenderDto.builder()
        .to(to)
        .subject(subject)
        .content(body)
        .build();

    final SendEmailResult sendEmailResult = new SendEmailResult();

    sendEmailService.send(subject, body, to);

    // then
  }


}