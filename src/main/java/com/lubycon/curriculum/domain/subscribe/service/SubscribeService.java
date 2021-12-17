package com.lubycon.curriculum.domain.subscribe.service;

import static com.lubycon.curriculum.domain.subscribe.domain.Email.subscriberEmail;

import com.lubycon.curriculum.domain.email.exception.EmailNotFoundException;
import com.lubycon.curriculum.domain.email.service.SubscribeAuthService;
import com.lubycon.curriculum.domain.subscribe.domain.Email;
import com.lubycon.curriculum.domain.subscribe.dto.SubscribeResponse;
import com.lubycon.curriculum.domain.subscribe.exception.FailedSubscribeException;
import com.lubycon.curriculum.domain.subscribe.repository.EmailRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SubscribeService {

  private final EmailRepository emailRepository;

  private final SubscribeAuthService subscribeAuthService;

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

  private void createEmailAndSendMail(final String email) {
    final String authCode = RandomStringUtils.randomAlphabetic(6);
    emailRepository.save(subscriberEmail(email, authCode));
    sendMail(email, authCode);
  }

  private void sendMail(final String email, final String authCode) {
    subscribeAuthService.sendSubscribeMail(email, authCode);
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
