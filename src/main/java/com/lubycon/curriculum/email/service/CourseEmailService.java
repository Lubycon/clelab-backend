package com.lubycon.curriculum.email.service;

import com.lubycon.curriculum.base.service.HttpRequestService;
import com.lubycon.curriculum.email.domain.EmailTemplate;
import com.lubycon.curriculum.subscribe.domain.Email;
import com.lubycon.curriculum.subscribe.repository.EmailRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseEmailService {

  @Value("${domain}")
  private String domain;

  private final EmailSender emailSender;
  private final EmailTemplateService emailTemplateService;
  private final HttpRequestService httpRequestService;
  private final EmailRepository emailRepository;

  public void sendToAllSubscribers(final long templateId) {
    final List<Email> subscribers = emailRepository.findAllBySubscribe(true);

    sendToAllReceivers(templateId, subscribers);
  }

  private void sendToAllReceivers(final long templateId, final List<Email> receivers) {

    final EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateById(templateId);
    final String body = httpRequestService.getBody(emailTemplate.getUrl());

    for (final Email receiver : receivers) {
      final String email = receiver.getEmail();
      final String name = email.substring(0, email.indexOf('@'));
      final String content = body.replace("{name}", name)
          .replace("{cancel_url}", domain + "/subscribe/cancel/" + email + "/" + receiver.getId());

      emailSender.sendMail(name, emailTemplate.getSubject(), content);
    }
  }

}
