package com.lubycon.curriculum.email.service;

import com.lubycon.curriculum.email.domain.EmailTemplate;
import com.lubycon.curriculum.email.exception.EmailTemplateNotFoundException;
import com.lubycon.curriculum.email.repository.EmailTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailTemplateService {

  private final EmailTemplateRepository emailTemplateRepository;

  public EmailTemplate getEmailTemplate() {
    return emailTemplateRepository.findFirstByOrderByCreatedAtDesc()
        .orElseThrow(EmailTemplateNotFoundException::new);
  }

  public EmailTemplate getEmailTemplateById(final long id) {
    return emailTemplateRepository.findById(id)
        .orElseThrow(EmailTemplateNotFoundException::new);
  }

}
