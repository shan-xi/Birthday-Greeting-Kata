package com.line.birthdaygreetingkata.controller;

import com.line.birthdaygreetingkata.entity.Member;
import com.line.birthdaygreetingkata.response.BaseResponse;
import com.line.birthdaygreetingkata.response.vo.BirthdayGreetingMessage;
import com.line.birthdaygreetingkata.response.vo.BirthdayGreetingMessageListVO;
import com.line.birthdaygreetingkata.service.BirthdayGreetingMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Birthday Greeting Message Controller
 */
@BaseResponse
@RestController
@RequestMapping(path = "/v1/birthday-greeting-messages/")
public class BirthdayGreetingMessageController {
    @Autowired
    private BirthdayGreetingMessageService birthdayGreetingMessageService;

    @GetMapping(path = "/version1", produces = MediaType.APPLICATION_JSON_VALUE)
    public BirthdayGreetingMessageListVO simpleMessageVersion1(@RequestParam(name = "pageNum") Optional<Integer> pageNum) {

        List<BirthdayGreetingMessage> obj = new ArrayList<>();
        Page<Member> page = birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday(pageNum.orElseGet(() -> 1));
        String titlePattern = "Happy birthday!";
        String contentPattern = "Happy birthday, dear %s!";
        for (Member m : page.getContent()) {
            obj.add(new BirthdayGreetingMessage(titlePattern, String.format(contentPattern, m.getFirstname())));
        }
        return new BirthdayGreetingMessageListVO(obj, pageNum.orElseGet(() -> 1), page.getTotalPages());
    }

    @GetMapping(path = "/version2", produces = MediaType.APPLICATION_JSON_VALUE)
    public BirthdayGreetingMessageListVO simpleMessageVersion2(@RequestParam(name = "pageNum") Optional<Integer> pageNum) {

        List<BirthdayGreetingMessage> obj = new ArrayList<>();
        Page<Member> page = birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday(pageNum.orElseGet(() -> 1));

        String maleTitlePattern = "Happy birthday!";
        String maleContentPattern =
                "Happy birthday, dear %s!" + System.lineSeparator() +
                        "We offer special discount 20%% off for the following items:" + System.lineSeparator() +
                        "White Wine, iPhone X";
        String femaleTitlePattern = "Happy birthday!";
        String femaleContentPattern =
                "Happy birthday, dear %s!" + System.lineSeparator() +
                        "We offer special discount 50%% off for the following items:" + System.lineSeparator() +
                        "Cosmetic, LV Handbags";

        for (Member m : page.getContent()) {
            if (m.getGender().equals("Male")) {
                obj.add(new BirthdayGreetingMessage(maleTitlePattern, String.format(maleContentPattern, m.getFirstname())));
            } else if (m.getGender().equals("Female")) {
                obj.add(new BirthdayGreetingMessage(femaleTitlePattern, String.format(femaleContentPattern, m.getFirstname())));
            }
        }
        return new BirthdayGreetingMessageListVO(obj, pageNum.orElseGet(() -> 1), page.getTotalPages());
    }
}
