package com.lubycon.curriculum.domain.email.service;

import com.lubycon.curriculum.domain.email.domain.EmailTemplate;
import com.lubycon.curriculum.domain.email.exception.EmailTemplateNotFoundException;
import com.lubycon.curriculum.domain.email.repository.EmailTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailTemplateService {

  private final EmailTemplateRepository emailTemplateRepository;

  public EmailTemplate getEmailTemplateById(final long id) {
    return emailTemplateRepository.findById(id)
        .orElseThrow(EmailTemplateNotFoundException::new);
  }

}
