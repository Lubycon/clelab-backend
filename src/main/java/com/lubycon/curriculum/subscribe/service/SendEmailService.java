package com.lubycon.curriculum.subscribe.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.lubycon.curriculum.base.service.HttpRequestService;
import com.lubycon.curriculum.subscribe.domain.Email;
import com.lubycon.curriculum.subscribe.domain.EmailTemplate;
import com.lubycon.curriculum.subscribe.dto.EmailSenderDto;
import com.lubycon.curriculum.subscribe.repository.EmailRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendEmailService {

  @Value("${aws.ses.greeting-url}")
  private String greetingUrl;

  @Value("${domain}")
  private String domain;

  private final EmailTemplateService emailTemplateService;
  private final AmazonSimpleEmailService amazonSimpleEmailService;
  private final EmailRepository emailRepository;
  private final HttpRequestService httpRequestService;

  public void sendToAllSubscribers(final long templateId) {
    final List<String> subscribers = emailRepository.findAll()
        .stream()
        .map(Email::getEmail)
        .collect(Collectors.toList());

    sendToAllReceivers(templateId, subscribers);
  }

  public void sendToReceivers(final long templateId, final List<String> receivers) {
    sendToAllReceivers(templateId, receivers);
  }

  public void sendSubscribeMail(final String email, final String authCode) {
    final String content = httpRequestService.getBody(greetingUrl);

    final EmailSenderDto senderDto = EmailSenderDto.builder()
        .to(email)
        .subject("인증을 완료해주세요!")
        .content(content.replace("{name}", email)
            .replace("{url}", domain + "/subscribe/regist/" + email + "/" + authCode))
        .build();

    sendMail(email, senderDto);
  }


  private void sendToAllReceivers(final long templateId, final List<String> receivers) {

    final EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateById(templateId);
    final String content = httpRequestService.getBody(emailTemplate.getUrl());

    for (final String receiver : receivers) {
      final String name = receiver.substring(0, receiver.indexOf('@'));

      final EmailSenderDto senderDto = EmailSenderDto.builder()
          .to(receiver)
          .subject(emailTemplate.getSubject())
          .content(content.replace("{name}", name))
          .build();

      sendMail(receiver, senderDto);
    }
  }

  private void sendMail(final String receiver, final EmailSenderDto senderDto) {
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
