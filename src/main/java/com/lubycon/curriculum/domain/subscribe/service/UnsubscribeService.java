package com.lubycon.curriculum.domain.subscribe.service;

import com.lubycon.curriculum.domain.email.exception.EmailNotFoundException;
import com.lubycon.curriculum.domain.subscribe.domain.Email;
import com.lubycon.curriculum.domain.subscribe.exception.FailedCancelSubscribeException;
import com.lubycon.curriculum.domain.subscribe.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UnsubscribeService {

  private final EmailRepository emailRepository;

  @Transactional
  public void unsubscribe(final String email, final Long id) {
    final Email findEmail = getByEmail(email);

    idMustBeSame(id, findEmail);
    findEmail.unsubscribe();
  }

  private void idMustBeSame(final Long id, final Email findEmail) {
    if (findEmail == null || !findEmail.getId().equals(id)) {
      throw new FailedCancelSubscribeException();
    }
  }

  private Email getByEmail(final String email) {
    return emailRepository.findByEmail(email)
        .orElseThrow(EmailNotFoundException::new);
  }

}
