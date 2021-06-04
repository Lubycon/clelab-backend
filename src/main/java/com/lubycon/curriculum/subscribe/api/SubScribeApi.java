package com.lubycon.curriculum.subscribe.api;

import com.lubycon.curriculum.subscribe.dto.TypeformSubscribeRequest;
import com.lubycon.curriculum.subscribe.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SubScribeApi {

  private final SubscribeService subscribeService;

  @PostMapping("/subscribe/typeform")
  public ResponseEntity<Object> typeformSubscribe(
      @RequestBody final TypeformSubscribeRequest request) {

    subscribeService.subscribe(request.getEmail());

    return ResponseEntity.ok()
        .build();
  }
}
