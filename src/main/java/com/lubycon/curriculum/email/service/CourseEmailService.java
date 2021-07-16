package com.lubycon.curriculum.email.service;

import com.lubycon.curriculum.base.service.HttpRequestService;
import com.lubycon.curriculum.email.domain.EmailTemplate;
import com.lubycon.curriculum.subscribe.domain.Email;
import com.lubycon.curriculum.subscribe.repository.EmailRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseEmailService {


  private final EmailSender emailSender;
  private final EmailTemplateService emailTemplateService;
  private final HttpRequestService httpRequestService;
  private final EmailRepository emailRepository;

  public void sendToAllSubscribers(final long templateId) {
    final List<String> subscribers = emailRepository.findAllBySubscribe(true)
        .stream()
        .map(Email::getEmail)
        .collect(Collectors.toList());

    sendToAllReceivers(templateId, subscribers);
  }

  public void sendToReceivers(final long templateId, final List<String> receivers) {
    sendToAllReceivers(templateId, receivers);
  }


  private void sendToAllReceivers(final long templateId, final List<String> receivers) {

    final EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateById(templateId);
    final String content = httpRequestService.getBody(emailTemplate.getUrl());

    for (final String receiver : receivers) {
      final String name = receiver.substring(0, receiver.indexOf('@'));
      emailSender.sendMail(receiver, emailTemplate.getSubject(), content.replace("{name}", name));
    }
  }

}
