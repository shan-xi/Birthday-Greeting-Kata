package com.line.birthdaygreetingkata.service;

import com.line.birthdaygreetingkata.entity.Member2;
import com.line.birthdaygreetingkata.repository.Member2Repository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Birthday Greeting Message Service using Mongodb repository
 */
@Service
public class BirthdayGreetingMessageService2Impl implements BirthdayGreetingMessageService2 {

    private Member2Repository member2Repository;

    public BirthdayGreetingMessageService2Impl(Member2Repository member2Repository) {
        this.member2Repository = member2Repository;
    }

    @Override
    public Page<Member2> getMembersByBirthdayEqualsToToday(int pageNum) {
        if (pageNum < 0) {
            pageNum = 0;
        }
        Pageable pageable = PageRequest.of(pageNum, 1000, Sort.by("id").ascending());
        return member2Repository.findMember2ByBirthday(new Date(), pageable);
    }
}
