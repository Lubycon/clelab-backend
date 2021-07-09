package com.lubycon.curriculum.subscribe.api;

import static com.lubycon.curriculum.base.util.HtmlResponseUtil.alertAndMove;

import com.lubycon.curriculum.subscribe.dto.SubscribeRequest;
import com.lubycon.curriculum.subscribe.dto.SubscribeResponse;
import com.lubycon.curriculum.subscribe.service.SubscribeService;
import com.lubycon.curriculum.subscribe.validation.SubscribeValidator;
import java.io.IOException;
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

  @InitBinder("subscribeRequest")
  public void initBinder(final WebDataBinder webDataBinder) {
    webDataBinder.addValidators(signUpValidator);
  }

  @PostMapping("/subscribe")
  public ResponseEntity<Object> sendSubscribeMail(
      @RequestBody @Valid final SubscribeRequest subscribeRequest) {
    final SubscribeResponse response = subscribeService
        .sendSubscribeMail(subscribeRequest.getEmail());

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(response);
  }

  @GetMapping("/subscribe/regist/{email}/{authCode}")
  public void subscribe(@PathVariable final String email,
      @PathVariable final String authCode) throws IOException {
    subscribeService.subscribe(email, authCode);
    alertAndMove("구독이 완료되었습니다.\\n 앞으로 코스가 열릴 때 마다 메일 발송이 될 예정입니다.", "https://clelab.io");
  }


  @GetMapping("/subscribe/cancel/{email}/{id}")
  public void cancelSubscribe(@PathVariable final String email, @PathVariable final Long id)
      throws IOException {
    subscribeService.cancelSubscribe(email, id);
    alertAndMove("구독이 해지되었습니다.", "https://clelab.io");

  }
}
