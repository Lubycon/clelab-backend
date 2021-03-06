package com.lubycon.curriculum.domain.subscribe.validation;

import com.lubycon.curriculum.domain.subscribe.domain.Email;
import com.lubycon.curriculum.domain.subscribe.dto.SubscribeRequest;
import com.lubycon.curriculum.domain.subscribe.exception.ConflictEmailException;
import com.lubycon.curriculum.domain.subscribe.repository.EmailRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Component
public class SubscribeValidator implements Validator {

  private final EmailRepository emailRepository;

  @Override
  public boolean supports(final Class<?> clazz) {
    return clazz.isAssignableFrom(SubscribeRequest.class);
  }

  @Override
  public void validate(final Object target, final Errors errors) {
    final SubscribeRequest addUserRequest = (SubscribeRequest) target;
    emailMustUnique(addUserRequest.getEmail());
  }

  private void emailMustUnique(final String email) {
    final Optional<Email> subscriber = emailRepository.findByEmail(email);

    if (subscriber.isPresent() && subscriber.get().isSubscribe()) {
      throw new ConflictEmailException();
    }
  }

}
