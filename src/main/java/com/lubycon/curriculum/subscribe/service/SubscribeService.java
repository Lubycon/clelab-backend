package com.lubycon.curriculum.subscribe.service;

import com.lubycon.curriculum.subscribe.domain.Email;
import com.lubycon.curriculum.subscribe.dto.SubscribeResponse;
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

}
