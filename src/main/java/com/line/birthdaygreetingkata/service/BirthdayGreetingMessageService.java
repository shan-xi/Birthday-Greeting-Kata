package com.line.birthdaygreetingkata.service;

import com.line.birthdaygreetingkata.entity.Member;
import org.springframework.data.domain.Page;

public interface BirthdayGreetingMessageService {
    Page<Member> getMembersByBirthdayEqualsToToday(int pageNum);

    Page<Member> getMembersByBirthdayEqualsToTodayAndAgeOverThan(int pageNum, int age);
}
