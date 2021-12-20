package com.lubycon.curriculum.domain.email.repository;

import com.lubycon.curriculum.domain.email.domain.Tester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TesterRepository extends JpaRepository<Tester, Long> {

}
