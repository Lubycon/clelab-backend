package com.lubycon.curriculum.email.repository;

import com.lubycon.curriculum.email.domain.EmailTemplate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {

  Optional<EmailTemplate> findFirstByOrderByCreatedAtDesc();

}
