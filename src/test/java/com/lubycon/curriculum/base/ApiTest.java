package com.lubycon.curriculum.base;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lubycon.curriculum.subscribe.filter.TypeformFilter;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class ApiTest {

  @Autowired
  protected MockMvc mockMvc;

  @Autowired
  protected ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext context;

  @BeforeEach
  public void mockMvcSetUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .addFilters(new CharacterEncodingFilter("UTF-8", true))
        .alwaysDo(print())
        .build();
  }

  public void typeformFilterMockMvcSetUp() {
    final TypeformFilter typeformFilter = new TypeformFilter();
    typeformFilter.setSecretKey("local");

    this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .addFilters(typeformFilter)
        .addFilters(new CharacterEncodingFilter("UTF-8", true))
        .alwaysDo(print())
        .build();
  }
}
