package com.lubycon.curriculum.subscribe.repository;

import com.lubycon.curriculum.subscribe.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
