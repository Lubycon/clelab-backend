package com.lubycon.curriculum.subscribe.service;

import com.lubycon.curriculum.subscribe.domain.EmailTemplate;
import com.lubycon.curriculum.subscribe.domain.Tester;
import com.lubycon.curriculum.subscribe.repository.TesterRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EmailTesterService {

  private final TesterRepository testerRepository;
  private final SendEmailService sendEmailService;
  private final EmailTemplateService emailTemplateService;

  @Transactional
  public void sendToTesters() {
    final List<String> testers = getTesters();
    final EmailTemplate emailTemplate = emailTemplateService.getEmailTemplate();

    if (!emailTemplate.isAlreadySent()) {
      sendEmailService.sendToReceivers(emailTemplate.getId(), testers);
      emailTemplate.sendComplete();
    }
  }

  public void sendSpecificTemplateToTesters(final long templateId) {
    final List<String> testers = getTesters();
    final EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateById(templateId);

    sendEmailService.sendToReceivers(emailTemplate.getId(), testers);
  }

  private List<String> getTesters() {
    return testerRepository
        .findAll()
        .stream()
        .map(Tester::getEmail)
        .collect(Collectors.toList());
  }
}
