package com.lubycon.curriculum.domain.email.service;

import static com.lubycon.curriculum.domain.subscribe.domain.Email.testerEmail;

import com.lubycon.curriculum.base.service.HttpRequestService;
import com.lubycon.curriculum.domain.email.domain.EmailTemplate;
import com.lubycon.curriculum.domain.email.domain.Tester;
import com.lubycon.curriculum.domain.subscribe.domain.Email;
import com.lubycon.curriculum.domain.subscribe.repository.EmailRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseSendEmailService {

  @Value("${domain}")
  private String domain;

  private final EmailService emailService;
  private final EmailTemplateService emailTemplateService;
  private final HttpRequestService httpRequestService;
  private final EmailRepository emailRepository;

  public void sendToAllSubscribers(final long templateId) {
    final List<Email> subscribers = emailRepository.findAllBySubscribe(true);

    sendToAllReceivers(templateId, subscribers);
  }

  public void sendToTesters(final long templateId, final List<Tester> testers) {
    final List<Email> subscribers = testers.stream()
        .map(e -> testerEmail(e.getEmail()))
        .collect(Collectors.toList());

    sendToAllReceivers(templateId, subscribers);
  }


  private void sendToAllReceivers(final long templateId, final List<Email> receivers) {

    final EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateById(templateId);
    final String body = httpRequestService.getBody(emailTemplate.getUrl());

    for (final Email receiver : receivers) {
      final String email = receiver.getEmail();
      final String name = email.substring(0, email.indexOf('@'));
      final String content = body.replace("{name}", name)
          .replace("{id}", String.valueOf(receiver.getId()))
          .replace("{cancel_url}", domain + "/subscribe/cancel/" + email + "/" + receiver.getId());

      emailService.sendMail(email, emailTemplate.getSubject(), content);
    }
  }

}
