package com.line.birthdaygreetingkata.response.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Birthday Greeting Message List Object
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class BirthdayGreetingMessageListVO {
    private List<BirthdayGreetingMessage> birthdayGreetingMessages;
    private Integer pageNum;
    private Integer totalPage;
}
