package com.lubycon.curriculum.subscribe.repository;

import com.lubycon.curriculum.subscribe.domain.Email;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

  boolean existsByEmail(String email);

  List<Email> findAllBySubscribe(boolean subscribe);

  Optional<Email> findByEmail(String email);
}
