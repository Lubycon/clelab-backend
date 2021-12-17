package com.lubycon.curriculum.domain.subscribe.repository;

import com.lubycon.curriculum.domain.subscribe.domain.Email;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

  List<Email> findAllBySubscribe(boolean subscribe);

  Optional<Email> findByEmail(String email);
}
