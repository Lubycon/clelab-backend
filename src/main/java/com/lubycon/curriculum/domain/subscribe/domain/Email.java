package com.lubycon.curriculum.domain.subscribe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

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

  private Email(final String email, final String authCode) {
    Assert.notNull(email, "email must be not null");
    Assert.notNull(authCode, "authCode must be not null");
    this.email = email;
    this.authCode = authCode;
  }

  public static Email testerEmail(final String email) {
    return new Email(email, "test");
  }

  public static Email subscriberEmail(final String email, final String authCode) {
    return new Email(email, authCode);
  }

  public boolean authCodeIsSame(final String authCode) {
    return this.authCode.equals(authCode);
  }

  public void subscribe() {
    this.subscribe = true;
  }

  public void unsubscribe() {
    this.subscribe = false;
  }

}
