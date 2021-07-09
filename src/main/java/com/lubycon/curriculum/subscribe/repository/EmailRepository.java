package com.lubycon.curriculum.subscribe.repository;

import com.lubycon.curriculum.subscribe.domain.Email;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

  boolean existsByEmail(String email);

  Optional<Email> findByEmail(String email);
}
