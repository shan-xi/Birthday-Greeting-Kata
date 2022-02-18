package com.line.birthdaygreetingkata.service;

import com.line.birthdaygreetingkata.entity.Member;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BirthdayGreetingMessageService {

    List<Member> getMembersByBirthdayEqualsToToday();

    Page<Member> getMembersByBirthdayEqualsToToday(int pageNum);

    Page<Member> getMembersByBirthdayEqualsToTodayAndAgeOverThan(int pageNum, int age);
}
