package com.line.birthdaygreetingkata.controller;

import com.line.birthdaygreetingkata.entity.Member;
import com.line.birthdaygreetingkata.entity.Member2;
import com.line.birthdaygreetingkata.response.BaseResponse;
import com.line.birthdaygreetingkata.response.vo.BirthdayGreetingMessage;
import com.line.birthdaygreetingkata.response.vo.BirthdayGreetingMessageList2VO;
import com.line.birthdaygreetingkata.response.vo.BirthdayGreetingMessageListVO;
import com.line.birthdaygreetingkata.response.vo.BirthdayGreetingMessageListWithPicVO;
import com.line.birthdaygreetingkata.service.BirthdayGreetingMessageService;
import com.line.birthdaygreetingkata.service.BirthdayGreetingMessageService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Birthday Greeting Message Controller
 */
@BaseResponse
@RestController
@RequestMapping(path = "/v1/birthday-greeting-messages/")
public class BirthdayGreetingMessageController {
    @Autowired
    private BirthdayGreetingMessageService birthdayGreetingMessageService;

    @Autowired
    private BirthdayGreetingMessageService2 birthdayGreetingMessageService2;

    @GetMapping(path = "/version1", produces = MediaType.APPLICATION_JSON_VALUE)
    public BirthdayGreetingMessageListVO simpleMessageVersion1(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum) {

        List<BirthdayGreetingMessage> obj = new ArrayList<>();
        Page<Member> page = birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday(pageNum);
        String titlePattern = "Happy birthday!";
        String contentPattern = "Happy birthday, dear %s!";
        for (Member m : page.getContent()) {
            obj.add(new BirthdayGreetingMessage(titlePattern, String.format(contentPattern, m.getFirstname())));
        }
        return new BirthdayGreetingMessageListVO(obj, pageNum, page.getTotalPages());
    }

    @GetMapping(path = "/version2", produces = MediaType.APPLICATION_JSON_VALUE)
    public BirthdayGreetingMessageListVO simpleMessageVersion2(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum) {

        List<BirthdayGreetingMessage> obj = new ArrayList<>();
        Page<Member> page = birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday(pageNum);

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
        return new BirthdayGreetingMessageListVO(obj, pageNum, page.getTotalPages());
    }

    @GetMapping(path = "/version3", produces = MediaType.APPLICATION_JSON_VALUE)
    public BirthdayGreetingMessageListWithPicVO simpleMessageVersion3(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum) {

        List<BirthdayGreetingMessage> obj = new ArrayList<>();
        Page<Member> page = birthdayGreetingMessageService.getMembersByBirthdayEqualsToTodayAndAgeOverThan(pageNum, 49);
        String titlePattern = "Happy birthday!";
        String contentPattern = "Happy birthday, dear `%s`!";
        String elderPicUrl = "https://tw.appledaily.com/resizer/UWiWwelfG_7uReQh6RbW8nKnB8g=/759x543/filters:quality(100)/cloudfront-ap-northeast-1.images.arcpublishing.com/appledaily/QMKJIWBMJCFUYRWKRO6XS6WVRI.jpg";
        for (Member m : page.getContent()) {
            obj.add(new BirthdayGreetingMessage(titlePattern, String.format(contentPattern, m.getFirstname())));
        }
        return new BirthdayGreetingMessageListWithPicVO(obj, elderPicUrl, pageNum, page.getTotalPages());
    }


    @GetMapping(path = "/version4", produces = MediaType.APPLICATION_JSON_VALUE)
    public BirthdayGreetingMessageListVO simpleMessageVersion4(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum) {

        List<BirthdayGreetingMessage> obj = new ArrayList<>();
        Page<Member> page = birthdayGreetingMessageService.getMembersByBirthdayEqualsToToday(pageNum);
        String titlePattern = "Happy birthday!";
        String contentPattern = "Happy birthday, dear %s, %s!";
        for (Member m : page.getContent()) {
            obj.add(new BirthdayGreetingMessage(titlePattern, String.format(contentPattern, m.getLastname(), m.getFirstname())));
        }
        return new BirthdayGreetingMessageListVO(obj, pageNum, page.getTotalPages());
    }

    @GetMapping(path = "/version5", produces = MediaType.APPLICATION_JSON_VALUE)
    public BirthdayGreetingMessageList2VO simpleMessageVersion5(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum) {

        List<BirthdayGreetingMessage> obj = new ArrayList<>();
        Page<Member2> page = birthdayGreetingMessageService2.getMembersByBirthdayEqualsToToday(pageNum);
        String titlePattern = "Happy birthday!";
        String contentPattern = "Happy birthday, dear %s!";
        for (Member2 m : page.getContent()) {
            obj.add(new BirthdayGreetingMessage(titlePattern, String.format(contentPattern, m.getFirstname())));
        }
        return new BirthdayGreetingMessageList2VO(obj, pageNum, page.getTotalPages());
    }
}
