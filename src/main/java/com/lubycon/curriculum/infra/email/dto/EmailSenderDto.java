package com.lubycon.curriculum.infra.email.dto;

import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
public class EmailSenderDto {

  public static final String SENDER = "Team Clelab<admin@clelab.io>";

  private final String to;
  private final String subject;
  private final String content;

  @Builder
  public EmailSenderDto(final String to, final String subject,
      final String content) {
    this.to = to;
    this.subject = subject;
    this.content = content;
  }

  public SendEmailRequest toSendRequestDto() {
    final Destination destination = new Destination()
        .withToAddresses(this.to);

    final Message message = new Message()
        .withSubject(createContent(this.subject))
        .withBody(new Body()
            .withHtml(createContent(this.content)));

    return new SendEmailRequest()
        .withSource(SENDER)
        .withDestination(destination)
        .withMessage(message);
  }

  private Content createContent(final String text) {
    return new Content()
        .withCharset("UTF-8")
        .withData(text);
  }
}
