package com.line.birthdaygreetingkata;

import com.line.birthdaygreetingkata.controller.BirthdayGreetingMessageController;
import com.line.birthdaygreetingkata.entity.Member;
import com.line.birthdaygreetingkata.service.BirthdayGreetingMessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest({BirthdayGreetingMessageController.class})
class BirthdayGreetingMessageControllerTest {

    @MockBean
    BirthdayGreetingMessageService birthdayGreetingMessageService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void simple_message_version1_should_return_success() throws Exception {
        Page<Member> tasks = Mockito.mock(Page.class);
        when(birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday(anyInt())).thenReturn(tasks);
        this.mockMvc.perform(get("/v1/birthday-greeting-messages/version1").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("SUCCESS"))
                .andExpect(jsonPath("$.msg").value("success"))
                .andExpect(content().string(containsString("birthdayGreetingMessages")));
    }
}
