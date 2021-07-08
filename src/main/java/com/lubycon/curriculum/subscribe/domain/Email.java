package com.lubycon.curriculum.subscribe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Email {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "is_subscribe", nullable = false, columnDefinition = "boolean default false")
  private boolean subscribe;

  @Column(name = "auth_code", nullable = false)
  private String authCode;

  public Email(final String email) {
    this.email = email;
  }
}
