package com.lubycon.curriculum.subscribe.service;

import com.lubycon.curriculum.subscribe.domain.EmailTemplate;
import com.lubycon.curriculum.subscribe.domain.Tester;
import com.lubycon.curriculum.subscribe.exception.EmailTemplateNotFound;
import com.lubycon.curriculum.subscribe.repository.EmailTemplateRepository;
import com.lubycon.curriculum.subscribe.repository.TesterRepository;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Profile("qa")
@Service
public class TestSubscribeScheduler {

  private final TesterRepository testerRepository;
  private final EmailTemplateRepository emailTemplateRepository;
  private final SendEmailService sendEmailService;

  @Scheduled(cron = "0 0 23 * * *")
  public void sendEmailToTester() throws UnirestException {
    final List<String> testers = getTesters();
    final EmailTemplate emailTemplate = getEmailTemplate();

    sendEmailService.sendToReceivers(emailTemplate.getSubject(),
        getBody(emailTemplate.getUrl()),
        testers);
  }

  private String getBody(final String url) throws UnirestException {
    return Unirest
        .get(url)
        .asString()
        .getBody();
  }

  private EmailTemplate getEmailTemplate() {
    return emailTemplateRepository.findFirstByOrderByCreatedAtDesc()
        .orElseThrow(EmailTemplateNotFound::new);
  }

  private List<String> getTesters() {
    return testerRepository
        .findAll()
        .stream()
        .map(Tester::getEmail)
        .collect(Collectors.toList());
  }
}
