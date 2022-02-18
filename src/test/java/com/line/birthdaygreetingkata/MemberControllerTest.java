package com.line.birthdaygreetingkata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.line.birthdaygreetingkata.controller.MemberController;
import com.line.birthdaygreetingkata.entity.Member;
import com.line.birthdaygreetingkata.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureDataMongo
class MemberControllerTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberController memberController;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void init() {
        Member m1 = new Member("Robert", "Yen", "Male", "1975/8/8", "robert.yen@linecorp.com");
        Member m2 = new Member("Cid", "Change", "Male", "1990/10/10", "cid.change@linecorp.com");
        Member m3 = new Member("Miki", "Lai", "Female", "1993/4/5", "miki.lai@linecorp.com");
        Member m4 = new Member("Sherry", "Chen", "Female", "1993/8/8", "sherry.lai@linecorp.com");
        Member m5 = new Member("Peter", "Wang", "Male", "1950/12/22", "peter.wang@linecorp.com");
        memberRepository.save(m1);
        memberRepository.save(m2);
        memberRepository.save(m3);
        memberRepository.save(m4);
        memberRepository.save(m5);
    }

    @AfterEach
    public void destroyAll() {
        memberRepository.deleteAll();
    }

    @Test
    public void contextLoads() {
        assertThat(memberController).isNotNull();
    }

    @Test
    public void should_return_success() throws Exception {
        this.mockMvc.perform(get("/member/all").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("SUCCESS"))
                .andExpect(content().string(containsString("SUCCESS")));
    }
}
