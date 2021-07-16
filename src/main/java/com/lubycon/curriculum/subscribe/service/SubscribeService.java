package com.lubycon.curriculum.subscribe.service;

import com.lubycon.curriculum.email.exception.EmailNotFoundException;
import com.lubycon.curriculum.email.service.SubscribeAuthEmailService;
import com.lubycon.curriculum.subscribe.domain.Email;
import com.lubycon.curriculum.subscribe.dto.SubscribeResponse;
import com.lubycon.curriculum.subscribe.exception.FailedCancelSubscribeException;
import com.lubycon.curriculum.subscribe.exception.FailedSubscribeException;
import com.lubycon.curriculum.subscribe.repository.EmailRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SubscribeService {

  private final EmailRepository emailRepository;

  private final SubscribeAuthEmailService subscribeAuthEmailService;

  @Transactional
  public SubscribeResponse sendSubscribeMail(final String email) {
    final Optional<Email> findEmail = emailRepository.findByEmail(email);

    if (findEmail.isPresent()) {
      sendMail(email, findEmail.get().getAuthCode());
    } else {
      createEmailAndSendMail(email);
    }

    return new SubscribeResponse(email);
  }

  @Transactional
  public void subscribe(final String email, final String authCode) {
    final Email subscriber = getByEmail(email);
    authCodeMustBeSame(authCode, subscriber);
    subscriber.subscribe();
  }

  public void cancelSubscribe(final String email, final Long id) {
    final Email findEmail = getByEmail(email);

    idMustBeSame(id, findEmail);
    emailRepository.delete(findEmail);
  }

  private void createEmailAndSendMail(final String email) {
    final String authCode = RandomStringUtils.randomAlphabetic(6);
    emailRepository.save(new Email(email, authCode));
    sendMail(email, authCode);
  }

  private void sendMail(final String email, final String authCode) {
    subscribeAuthEmailService.sendSubscribeMail(email, authCode);
  }

  private void idMustBeSame(final Long id, final Email findEmail) {
    if (findEmail == null || !findEmail.getId().equals(id)) {
      throw new FailedCancelSubscribeException();
    }
  }

  private void authCodeMustBeSame(final String authCode, final Email findEmail) {
    if (!findEmail.authCodeIsSame(authCode)) {
      throw new FailedSubscribeException();
    }
  }

  private Email getByEmail(final String email) {
    return emailRepository.findByEmail(email)
        .orElseThrow(EmailNotFoundException::new);
  }

}
