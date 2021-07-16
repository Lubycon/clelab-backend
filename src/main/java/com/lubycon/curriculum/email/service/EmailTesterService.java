package com.lubycon.curriculum.email.service;

import com.lubycon.curriculum.email.domain.EmailTemplate;
import com.lubycon.curriculum.email.domain.Tester;
import com.lubycon.curriculum.email.repository.TesterRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EmailTesterService {

  private final TesterRepository testerRepository;
  private final CourseEmailService sendEmailService;
  private final EmailTemplateService emailTemplateService;

  @Transactional
  public void sendToTesters() {
    final List<Tester> testers = getTesters();
    final EmailTemplate emailTemplate = emailTemplateService.getEmailTemplate();

    if (!emailTemplate.isAlreadySent()) {
      sendEmailService.sendToTesters(emailTemplate.getId(), testers);
      emailTemplate.sendComplete();
    }
  }

  public void sendSpecificTemplateToTesters(final long templateId) {
    final List<Tester> testers = getTesters();
    final EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateById(templateId);

    sendEmailService.sendToTesters(emailTemplate.getId(), testers);
  }

  private List<Tester> getTesters() {
    return testerRepository
        .findAll();
  }
}