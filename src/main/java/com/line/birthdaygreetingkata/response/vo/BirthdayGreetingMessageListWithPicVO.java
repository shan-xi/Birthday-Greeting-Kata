package com.line.birthdaygreetingkata.response.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Birthday Greeting Message List with Picture Object View Object
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class BirthdayGreetingMessageListWithPicVO {
    /**
     * Message data
     */
    private List<BirthdayGreetingMessage> birthdayGreetingMessages;
    /**
     * Elder Picture
     */
    private String elderPicUrl;
    /**
     * current page number
     */
    private Integer pageNum;
    /**
     * total pages
     */
    private Integer totalPage;
}
