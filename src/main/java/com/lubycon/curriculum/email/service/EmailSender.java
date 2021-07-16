package com.lubycon.curriculum.email.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.lubycon.curriculum.email.dto.EmailSenderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSender {

  private final AmazonSimpleEmailService amazonSimpleEmailService;

  public void sendMail(final String receiver, final String subject, final String content) {
    final EmailSenderDto senderDto = EmailSenderDto.builder()
        .to(receiver)
        .subject(subject)
        .content(content)
        .build();

    final SendEmailResult sendEmailResult = amazonSimpleEmailService
        .sendEmail(senderDto.toSendRequestDto());

    sendingResultMustSuccess(sendEmailResult, receiver);
  }


  private void sendingResultMustSuccess(final SendEmailResult sendEmailResult,
      final String receiver) {
    if (sendEmailResult.getSdkHttpMetadata().getHttpStatusCode() != 200) {
      log.error("메일 전송 실패 : {}", receiver);
      log.error("{}", sendEmailResult.getSdkResponseMetadata().toString());
    }
  }

}
