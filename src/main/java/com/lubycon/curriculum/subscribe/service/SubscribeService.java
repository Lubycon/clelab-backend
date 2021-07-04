package com.lubycon.curriculum.subscribe.service;

import com.lubycon.curriculum.subscribe.domain.Email;
import com.lubycon.curriculum.subscribe.dto.SubscribeResponse;
import com.lubycon.curriculum.subscribe.exception.FailedCancelSubscribeException;
import com.lubycon.curriculum.subscribe.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscribeService {

  private final EmailRepository emailRepository;

  public SubscribeResponse subscribe(final String email) {
    final Email savedEmail = emailRepository.save(new Email(email));
    return new SubscribeResponse(savedEmail);
  }

  public void cancelSubscribe(final String email, final Long id) {
    final Email findEmail = emailRepository.findByEmail(email);

    idMustBeSame(id, findEmail);
    emailRepository.delete(findEmail);
  }

  private void idMustBeSame(final Long id, final Email findEmail) {
    if (findEmail == null || !findEmail.getId().equals(id)) {
      throw new FailedCancelSubscribeException();
    }
  }

}
