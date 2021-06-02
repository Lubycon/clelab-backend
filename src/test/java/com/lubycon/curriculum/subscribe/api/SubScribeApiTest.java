package com.lubycon.curriculum.subscribe.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.lubycon.curriculum.base.ApiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

class SubScribeApiTest extends ApiTest {

  @DisplayName("Typeform 웹훅을 통해 이메일을 저장할 수 있다.")
  @Test
  public void typeformWebHookTest() throws Exception {
    // given
    final String url = "/subscribe/typeform";
    final String email = "test@mail.com";
    final String body = getRequestBody(email);

    // when
    final ResultActions resultActions = mockMvc.perform(post(url)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON)
        .content(body));

    // then
    resultActions
        .andExpect(status().isOk());
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