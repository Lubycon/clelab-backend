package com.lubycon.curriculum.subscribe.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.lubycon.curriculum.subscribe.domain.Email;
import com.lubycon.curriculum.subscribe.dto.EmailSenderDto;
import com.lubycon.curriculum.subscribe.exception.FailedSendMailException;
import com.lubycon.curriculum.subscribe.repository.EmailRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendEmailService {

  private final AmazonSimpleEmailService amazonSimpleEmailService;
  private final EmailRepository emailRepository;

  public void sendToAllSubscribers(final String subject, final String content) {
    final List<String> subscribers = emailRepository.findAll()
        .stream()
        .map(Email::getEmail)
        .collect(Collectors.toList());

    send(subject, content, subscribers);
  }

  public void sendToReceivers(final String subject, final String content,
      final List<String> receivers) {
    send(subject, content, receivers);
  }

  private void send(final String subject, final String content, final List<String> receivers) {

    for (final String receiver : receivers) {
      final String name = receiver.substring(0, receiver.indexOf('@'));

      final EmailSenderDto senderDto = EmailSenderDto.builder()
          .to(Arrays.asList(receiver))
          .subject(subject)
          .content(content.replace("{name}", name))
          .build();

      final SendEmailResult sendEmailResult = amazonSimpleEmailService
          .sendEmail(senderDto.toSendRequestDto());

      sendingResultMustSuccess(sendEmailResult);
    }

  }


  private void sendingResultMustSuccess(final SendEmailResult sendEmailResult) {
    if (sendEmailResult.getSdkHttpMetadata().getHttpStatusCode() != 200) {
      throw new FailedSendMailException(sendEmailResult.getSdkResponseMetadata().toString());
    }
  }

}
