package com.line.birthdaygreetingkata.service;

import com.line.birthdaygreetingkata.entity.Member;
import com.line.birthdaygreetingkata.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Birthday Greeting Message Service using Mysql Repository
 */
@Service
public class BirthdayGreetingMessageServiceImpl implements BirthdayGreetingMessageService {

    private MemberRepository memberRepository;

    public BirthdayGreetingMessageServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Page<Member> getMembersByBirthdayEqualsToToday(int pageNum) {
        if (pageNum < 0) {
            pageNum = 0;
        }
        LocalDate localDate = LocalDate.now();
        String birthdayString = localDate.format(DateTimeFormatter.ofPattern("MM/dd"));
        Pageable pageableRequest = PageRequest.of(pageNum, 1000, Sort.Direction.ASC, "id");
        return memberRepository.findByBirthday(birthdayString, pageableRequest);
    }

    @Override
    public Page<Member> getMembersByBirthdayEqualsToTodayAndAgeOverThan(int pageNum, int age) {
        if (pageNum < 0) {
            pageNum = 0;
        }
        LocalDate localDate = LocalDate.now();
        String birthdayString = localDate.format(DateTimeFormatter.ofPattern("MM/dd"));
        Pageable pageableRequest = PageRequest.of(pageNum, 1000, Sort.Direction.ASC, "id");
        return memberRepository.findByBirthdayAndAgeOverThan(birthdayString, age, pageableRequest);
    }
}
