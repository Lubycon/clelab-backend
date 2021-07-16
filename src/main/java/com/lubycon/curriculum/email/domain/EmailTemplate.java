package com.lubycon.curriculum.email.domain;

import java.time.LocalDateTime;
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
public class EmailTemplate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "subject")
  private String subject;

  @Column(name = "url")
  private String url;

  @Column(name = "is_send")
  private boolean send;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  public boolean isAlreadySent() {
    return send;
  }

  public void sendComplete() {
    this.send = true;
  }

}
