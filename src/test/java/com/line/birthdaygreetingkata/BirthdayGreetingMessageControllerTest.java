package com.line.birthdaygreetingkata;

import com.line.birthdaygreetingkata.controller.BirthdayGreetingMessageController;
import com.line.birthdaygreetingkata.entity.Member;
import com.line.birthdaygreetingkata.repository.Member2Repository;
import com.line.birthdaygreetingkata.repository.MemberRepository;
import com.line.birthdaygreetingkata.service.BirthdayGreetingMessageService;
import com.line.birthdaygreetingkata.service.BirthdayGreetingMessageService2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.xml;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest({BirthdayGreetingMessageController.class})
@AutoConfigureDataMongo
class BirthdayGreetingMessageControllerTest {

    @MockBean
    BirthdayGreetingMessageService birthdayGreetingMessageService;
    @MockBean
    BirthdayGreetingMessageService2 birthdayGreetingMessageService2;
    @MockBean
    MemberRepository memberRepository;
    @MockBean
    Member2Repository member2Repository;
    @Autowired
    MockMvc mockMvc;

    Page<Member> page;

    @BeforeEach
    public void init() {
        List<Member> members = new ArrayList<>();
        members.add(new Member("Robert", "Yen", "Male", "1975/8/8", "robert.yen@linecorp.com"));
        members.add(new Member("Cid", "Change", "Male", "1990/10/10", "cid.change@linecorp.com"));
        members.add(new Member("Miki", "Lai", "Female", "1993/4/5", "miki.lai@linecorp.com"));
        members.add(new Member("Sherry", "Chen", "Female", "1993/8/8", "sherry.lai@linecorp.com"));
        members.add(new Member("Peter", "Wang", "Male", "1950/12/22", "peter.wang@linecorp.com"));
        page = new PageImpl<>(members);
    }

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

    @Test
    public void simple_message_version2_should_return_success() throws Exception {
        when(birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday(anyInt())).thenReturn(page);
        this.mockMvc.perform(get("/v1/birthday-greeting-messages/version2").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("SUCCESS"))
                .andExpect(jsonPath("$.msg").value("success"))
                .andExpect(content().string(containsString("birthdayGreetingMessages")))
                .andExpect(content().string(containsString("Robert")));
    }

    @Test
    public void simple_message_version2_should_return_success_and_birthdayGreetingMessages_is_empty() throws Exception {
        page = new PageImpl<Member>(new ArrayList<>());
        when(birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday(anyInt())).thenReturn(page);
        this.mockMvc.perform(get("/v1/birthday-greeting-messages/version2").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("SUCCESS"))
                .andExpect(jsonPath("$.msg").value("success"))
                .andExpect(content().string(containsString("\"birthdayGreetingMessages\":[]")));
    }

    @Test
    public void simple_message_version3_should_return_success() throws Exception {
        List<Member> members = new ArrayList<>();
        members.add(new Member("Robert", "Yen", "Male", "1973/2/17", "robert.yen@linecorp.com"));
        members.add(new Member("Peter", "Wang", "Male", "1950/2/17", "peter.wang@linecorp.com"));
        Page<Member> page = new PageImpl<>(members);
        when(birthdayGreetingMessageService.getMembersByBirthdayEqualsToTodayAndAgeOverThan(anyInt(), anyInt())).thenReturn(page);
        this.mockMvc.perform(get("/v1/birthday-greeting-messages/version3").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("SUCCESS"))
                .andExpect(jsonPath("$.msg").value("success"))
                .andExpect(content().string(containsString("elderPicUrl")))
                .andExpect(content().string(containsString("Peter")));
    }

    @Test
    public void simple_message_version6_should_return_success() throws Exception {
        List<Member> members = new ArrayList<>();
        members.add(new Member("Robert", "Yen", "Male", "1973/2/17", "robert.yen@linecorp.com"));
        members.add(new Member("Peter", "Wang", "Male", "1950/2/17", "peter.wang@linecorp.com"));
        when(birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday()).thenReturn(members);
        this.mockMvc.perform(get("/v1/birthday-greeting-messages/version6").contentType(MediaType.APPLICATION_XHTML_XML))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<root>")))
                .andExpect(content().string(containsString("<message>")))
                .andExpect(content().string(containsString("<content>Happy birthday, dear Robert!</content>")))
                .andExpect(content().string(containsString("<content>Happy birthday, dear Peter!</content>")))
        ;
    }
}
