package com.lubycon.curriculum.domain.email.service;

import com.lubycon.curriculum.domain.email.domain.EmailTemplate;
import com.lubycon.curriculum.domain.email.domain.Tester;
import com.lubycon.curriculum.domain.email.repository.TesterRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailTesterService {

  private final TesterRepository testerRepository;
  private final CourseSendEmailService sendEmailService;
  private final EmailTemplateService emailTemplateService;

  public void sendMailToTestersByTemplateId(final long templateId) {
    final List<Tester> testers = getTesters();
    final EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateById(templateId);

    sendEmailService.sendToTesters(emailTemplate.getId(), testers);
  }

  private List<Tester> getTesters() {
    return testerRepository
        .findAll();
  }
}
