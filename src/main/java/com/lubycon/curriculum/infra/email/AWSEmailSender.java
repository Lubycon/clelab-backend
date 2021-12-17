package com.lubycon.curriculum.infra.email;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.lubycon.curriculum.infra.email.dto.EmailSenderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class AWSEmailSender {

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


  private void sendingResultMustSuccess(final SendEmailResult result, final String receiver) {
    if (!successSendMail(result)) {
      log.error("메일 전송 실패 : {}", receiver);
      log.error("{}", result.getSdkResponseMetadata().toString());
    }
  }

  private boolean successSendMail(final SendEmailResult sendEmailResult) {
    return sendEmailResult.getSdkHttpMetadata().getHttpStatusCode() == 200;
  }

}
