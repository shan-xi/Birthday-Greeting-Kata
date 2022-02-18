package com.line.birthdaygreetingkata.service;

import com.line.birthdaygreetingkata.entity.Member2;
import org.springframework.data.domain.Page;


public interface BirthdayGreetingMessageService2 {
    Page<Member2> getMembersByBirthdayEqualsToToday(int pageNum);
}
