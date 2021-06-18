package com.lubycon.curriculum.subscribe.service;

import com.lubycon.curriculum.subscribe.domain.EmailTemplate;
import com.lubycon.curriculum.subscribe.exception.EmailTemplateNotFound;
import com.lubycon.curriculum.subscribe.repository.EmailTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailTemplateService {

  private final EmailTemplateRepository emailTemplateRepository;

  public EmailTemplate getEmailTemplate() {
    return emailTemplateRepository.findFirstByOrderByCreatedAtDesc()
        .orElseThrow(EmailTemplateNotFound::new);
  }

  public EmailTemplate getEmailTemplateById(final long id) {
    return emailTemplateRepository.findById(id)
        .orElseThrow(EmailTemplateNotFound::new);
  }

}
