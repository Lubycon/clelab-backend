package com.lubycon.curriculum.domain.email.api;

import com.lubycon.curriculum.domain.email.dto.SendMailToSubscribersRequest;
import com.lubycon.curriculum.domain.email.service.CourseEmailService;
import com.lubycon.curriculum.domain.email.service.EmailTesterService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SendEmailApi {

  private final CourseEmailService courseEmailService;
  private final EmailTesterService emailTesterService;

  @PostMapping("/mail/testers/{templateId}")
  public ResponseEntity<Object> sendMailToTester(@PathVariable final long templateId) {

    emailTesterService.sendSpecificTemplateToTesters(templateId);

    return ResponseEntity.ok().build();
  }

  @PostMapping("/mail/subscribers")
  public ResponseEntity<Object> sendMailToSubscribers(
      @RequestBody @Valid final SendMailToSubscribersRequest request) {

    courseEmailService.sendToAllSubscribers(request.getTemplateId());

    return ResponseEntity.ok().build();
  }

}
