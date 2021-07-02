package com.lubycon.curriculum.subscribe.api;

import com.lubycon.curriculum.subscribe.dto.SubscribeRequest;
import com.lubycon.curriculum.subscribe.dto.SubscribeResponse;
import com.lubycon.curriculum.subscribe.dto.TypeformSubscribeRequest;
import com.lubycon.curriculum.subscribe.service.SubscribeService;
import com.lubycon.curriculum.subscribe.validation.SubscribeValidator;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SubScribeApi {

  private final SubscribeService subscribeService;

  private final SubscribeValidator signUpValidator;

  @PostMapping("/subscribe/typeform")
  public ResponseEntity<Object> typeformSubscribe(
      @RequestBody final TypeformSubscribeRequest request) {

    subscribeService.subscribe(request.getEmail());

    return ResponseEntity.ok()
        .build();
  }

  @InitBinder("subscribeRequest")
  public void initBinder(final WebDataBinder webDataBinder) {
    webDataBinder.addValidators(signUpValidator);
  }

  @PostMapping("/subscribe")
  public ResponseEntity<Object> subscribe(
      @RequestBody @Valid final SubscribeRequest subscribeRequest) {
    final SubscribeResponse response = subscribeService.subscribe(subscribeRequest.getEmail());

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(response);
  }

  @GetMapping("/subscribe/cancel/{email}/{id}")
  public void cancelSubscribe(@PathVariable final String email, @PathVariable final Long id) {
    subscribeService.cancelSubscribe(email, id);
  }
}
