package com.lubycon.curriculum.subscribe.repository;

import com.lubycon.curriculum.subscribe.domain.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {

}
