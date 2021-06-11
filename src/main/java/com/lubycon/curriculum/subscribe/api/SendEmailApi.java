package com.lubycon.curriculum.subscribe.api;

import com.lubycon.curriculum.subscribe.dto.SendMailRequest;
import com.lubycon.curriculum.subscribe.dto.SendMailToSubscribersRequest;
import com.lubycon.curriculum.subscribe.service.SendEmailService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SendEmailApi {

  private final SendEmailService sendEmailService;

  @PostMapping("/mail/subscribers")
  public ResponseEntity<Object> sendMailToSubscribers(
      @RequestBody @Valid final SendMailToSubscribersRequest request) {

    sendEmailService.sendToAllSubscribers(request.getSubject(), request.getBody());

    return ResponseEntity.ok().build();
  }

  @PostMapping("/mail")
  public ResponseEntity<Object> sendMail(
      @RequestBody @Valid final SendMailRequest request) {

    sendEmailService.sendToReceivers(request.getSubject(), request.getBody(), request.getTo());

    return ResponseEntity.ok().build();
  }

}