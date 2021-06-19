package com.lubycon.curriculum.subscribe.api;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.lubycon.curriculum.base.ApiTest;
import com.lubycon.curriculum.base.error.ErrorCode;
import com.lubycon.curriculum.subscribe.dto.SubscribeRequest;
import com.lubycon.curriculum.subscribe.exception.TypeFormSecretNotEqualsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.ResultActions;

class SubScribeApiTest extends ApiTest {

  @DisplayName("Typeform 웹훅을 통해 이메일을 저장할 수 있다.")
  @Test
  public void typeformWebHookTest() throws Exception {
    // given
    typeformFilterMockMvcSetUp();

    final String url = "/subscribe/typeform";
    final String email = "test@mail.com";
    final String body = getRequestBody(email);

    // when
    final ResultActions resultActions = mockMvc.perform(post(url)
        .header("Typeform-Signature", "local")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON)
        .content(body));

    // then
    resultActions
        .andExpect(status().isOk());
  }


  @DisplayName("Typeform 비밀키가 다르면 401이 발생한다.")
  @Test
  public void typeformWebHook401Test() throws Exception {
    // given
    typeformFilterMockMvcSetUp();

    final String url = "/subscribe/typeform";
    final String email = "test@mail.com";
    final String wrongSecretKey = "wrong_secret_key";
    final String body = getRequestBody(email);

    // when
    assertThatThrownBy(() -> {
      mockMvc.perform(post(url)
          .header("Typeform-Signature", wrongSecretKey)
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .accept(MediaType.APPLICATION_JSON)
          .content(body));
    })
        .isInstanceOf(TypeFormSecretNotEqualsException.class) // then
        .hasMessageContaining(ErrorCode.TYPEFORM_SECRET_NOT_EQUALS.getMessage() + wrongSecretKey);
  }

  @DisplayName("이메일을 통해 구독 신청을 할 수 있다.")
  @Test
  public void subscribeApiTest() throws Exception {
    // given
    final String url = "/subscribe";
    final String email = "test@mail.com";

    final SubscribeRequest request = new SubscribeRequest();
    request.setEmail(email);

    // when
    final ResultActions resultActions = mockMvc.perform(post(url)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)));

    // then
    resultActions
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.email").value(email));
  }

  @Sql("/make-email.sql")
  @DisplayName("이미 있는 이메일이라면 409가 발생한다.")
  @Test
  public void subscribeApi409Test() throws Exception {
    // given
    final String url = "/subscribe";
    final String existEmail = "exist@email.com";

    final SubscribeRequest request = new SubscribeRequest();
    request.setEmail(existEmail);

    // when
    final ResultActions resultActions = mockMvc.perform(post(url)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)));

    // then
    resultActions
        .andExpect(status().isConflict())
        .andExpect(jsonPath("$.message").value(ErrorCode.CONFLICT_EMAIL.getMessage()));
  }


  private String getRequestBody(final String email) {
    return "{\n"
        + "  \"event_type\": \"form_response\",\n"
        + "  \"form_response\": {\n"
        + "    \"landed_at\": \"2021-06-02T07:21:56Z\",\n"
        + "    \"submitted_at\": \"2021-06-02T07:22:44Z\",\n"
        + "    \"definition\": {\n"
        + "      \"title\": \"Clelab  - 사전신청\",\n"
        + "      \"fields\": [\n"
        + "        {\n"
        + "          \"title\": \"관심있는 주제\",\n"
        + "          \"type\": \"multiple_choice\",\n"
        + "          \"choices\": [\n"
        + "            {\n"
        + "              \"label\": \"HTML, CSS, JS\"\n"
        + "            },\n"
        + "            {\n"
        + "              \"label\": \"SASS\"\n"
        + "            }\n"
        + "          ]\n"
        + "        },\n"
        + "        {\n"
        + "          \"title\": \"메일 주소 응답!\",\n"
        + "          \"type\": \"email\"\n"
        + "        }\n"
        + "      ]\n"
        + "    },\n"
        + "    \"answers\": [\n"
        + "      {\n"
        + "        \"type\": \"choices\",\n"
        + "        \"choices\": {\n"
        + "          \"labels\": [\n"
        + "            \"HTML, CSS, JS\",\n"
        + "            \"CSS\",\n"
        + "            \"React\"\n"
        + "          ]\n"
        + "        },\n"
        + "        \"field\": {\n"
        + "          \"type\": \"multiple_choice\"\n"
        + "        }\n"
        + "      },\n"
        + "      {\n"
        + "        \"type\": \"email\",\n"
        + "        \"email\": \"" + email + "\",\n"
        + "        \"field\": {\n"
        + "          \"type\": \"email\"\n"
        + "        }\n"
        + "      }\n"
        + "    ]\n"
        + "  }\n"
        + "}";
  }


}