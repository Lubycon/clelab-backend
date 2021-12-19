package com.lubycon.curriculum.domain.subscribe.api;

import static com.lubycon.curriculum.base.util.JavascriptUtil.alertAndMove;

import com.lubycon.curriculum.domain.subscribe.service.UnsubscribeService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UnsubScribeApi {

  public static final String CLELAB_HOME_URL = "https://clelab.io";
  private final UnsubscribeService unsubscribeService;

  @GetMapping("/subscribe/cancel/{email}/{id}")
  public void cancelSubscribe(@PathVariable final String email, @PathVariable final Long id)
      throws IOException {
    unsubscribeService.unsubscribe(email, id);
    alertAndMove("구독이 해지되었습니다.", CLELAB_HOME_URL);

  }
}
