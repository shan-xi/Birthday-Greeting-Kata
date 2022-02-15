package com.line.birthdaygreetingkata.controller;

import com.line.birthdaygreetingkata.response.vo.MemberListVO;
import com.line.birthdaygreetingkata.repository.MemberRepository;
import com.line.birthdaygreetingkata.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Member Controller
 */
@BaseResponse
@RestController
@RequestMapping(path = "/member")
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping(path = "/all")
    public MemberListVO getAllMembers() {

        return new MemberListVO(memberRepository.findAll());
    }
}