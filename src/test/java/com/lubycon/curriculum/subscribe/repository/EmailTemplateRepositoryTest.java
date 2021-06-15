package com.lubycon.curriculum.subscribe.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.subscribe.domain.EmailTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

class EmailTemplateRepositoryTest extends RepositoryTest {

  @Autowired
  private EmailTemplateRepository emailTemplateRepository;

  @Sql("/make-email-template.sql")
  @DisplayName("가장 최근 이메일 템플릿 가져오기 테스트")
  @Test
  public void majorCompanyFrequencyOneToOneTest() {
    final EmailTemplate emailTemplate = emailTemplateRepository.findFirstByOrderByCreatedAtDesc()
        .get();

    assertThat(emailTemplate.getFileName()).isEqualTo("url2");
    assertThat(emailTemplate.getSubject()).isEqualTo("제목2");
  }


}