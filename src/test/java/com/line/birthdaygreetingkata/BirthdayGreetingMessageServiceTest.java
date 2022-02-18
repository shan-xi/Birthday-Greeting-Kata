package com.line.birthdaygreetingkata;

import com.line.birthdaygreetingkata.entity.Member;
import com.line.birthdaygreetingkata.repository.MemberRepository;
import com.line.birthdaygreetingkata.service.BirthdayGreetingMessageService;
import com.line.birthdaygreetingkata.service.BirthdayGreetingMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BirthdayGreetingMessageServiceTest {

    BirthdayGreetingMessageService birthdayGreetingMessageService;

    @Mock
    MemberRepository memberRepository;

    @BeforeEach
    void initUseCase() {
        birthdayGreetingMessageService = new BirthdayGreetingMessageServiceImpl(memberRepository);
    }

    Page<Member> page;

    @Test
    public void get_members_by_birthday_equals_to_today_no_data_found() {
        List<Member> members = new ArrayList<>();
        Page<Member> page2 = new PageImpl<>(members);
        when(memberRepository.findByBirthday(any(), any())).thenReturn(page2);
        Page<Member> r = birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday(1);
        assertThat(r.getContent().size()).isEqualTo(0);
    }

    @Test
    public void get_members_by_birthday_found_two_records() {
        List<Member> members = new ArrayList<>();
        members.add(new Member("Robert", "Yen", "Male", "1975/2/17", "robert.yen@linecorp.com"));
        members.add(new Member("Sherry", "Chen", "Female", "1993/2/17", "sherry.lai@linecorp.com"));
        page = new PageImpl<>(members);
        when(memberRepository.findByBirthday(any(), any())).thenReturn(page);
        Page<Member> r = birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday(1);
        assertThat(r.getContent().size()).isEqualTo(2);
    }

    @Test
    public void get_members_by_birthday_equals_to_today_and_age_over_than_found_two_records() {
        List<Member> members = new ArrayList<>();
        members.add(new Member("Robert", "Yen", "Male", "1973/2/18", "robert.yen@linecorp.com"));
        members.add(new Member("Sherry", "Chen", "Female", "1993/2/18", "sherry.lai@linecorp.com"));
        page = new PageImpl<>(members);
        when(memberRepository.findByBirthdayAndAgeOverThan(any(), any(), any())).thenReturn(page);
        Page<Member> r = birthdayGreetingMessageService.getMembersByBirthdayEqualsToTodayAndAgeOverThan(1, 49);
        assertThat(r.getContent().size()).isEqualTo(2);
    }
}
