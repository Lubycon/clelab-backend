package com.lubycon.curriculum.domain.email.service;

public interface EmailService {

  void sendMail(final String receiver, final String subject, final String content);
}
