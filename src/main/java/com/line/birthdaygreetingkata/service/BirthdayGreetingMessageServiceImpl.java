package com.line.birthdaygreetingkata.service;

import com.line.birthdaygreetingkata.entity.Member;
import com.line.birthdaygreetingkata.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Birthday Greeting Message Service
 */
@Service
public class BirthdayGreetingMessageServiceImpl implements BirthdayGreetingMessageService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Page<Member> getMembersByBirthdayEqualsToToday(int pageNum) {
        if (pageNum < 1) {
            pageNum = 1;
        }
        LocalDate localDate = LocalDate.now();
        String birthdayString = localDate.format(DateTimeFormatter.ofPattern("MM/dd"));
        Pageable pageableRequest = PageRequest.of(pageNum - 1, 1000, Sort.Direction.ASC, "id");
        return memberRepository.findByBirthday(birthdayString, pageableRequest);
    }
}
