package com.lubycon.curriculum.subscribe.validation;

import com.lubycon.curriculum.subscribe.dto.SubscribeRequest;
import com.lubycon.curriculum.subscribe.exception.ConflictEmailException;
import com.lubycon.curriculum.subscribe.repository.EmailRepository;
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
    if (emailRepository.existsByEmail(email)) {
      throw new ConflictEmailException();
    }
  }

}
