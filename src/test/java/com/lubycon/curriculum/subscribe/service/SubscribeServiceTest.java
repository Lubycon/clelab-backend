package com.lubycon.curriculum.subscribe.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.subscribe.domain.Email;
import com.lubycon.curriculum.subscribe.repository.EmailRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class SubscribeServiceTest {

  @Autowired
  SubscribeService subscribeService;

  @Autowired
  EmailRepository emailRepository;

  @DisplayName("이메일로 구독을 할 수 있다.")
  @Test
  public void getSectionTest() {
    // when
    final String email = "test@email.com";
    subscribeService.subscribe(email);

    // then
    final List<Email> emails = emailRepository.findAll();
    assertThat(emails.get(0).getEmail()).isEqualTo(email);
  }

}