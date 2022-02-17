package com.line.birthdaygreetingkata.response.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Birthday Greeting Message List with Picture Object
 */
@Data
@AllArgsConstructor
public class BirthdayGreetingMessageListWithPicVO {
    private List<BirthdayGreetingMessage> birthdayGreetingMessages;
    private String elderPicUrl;
    private Integer pageNum;
    private Integer totalPage;
}
