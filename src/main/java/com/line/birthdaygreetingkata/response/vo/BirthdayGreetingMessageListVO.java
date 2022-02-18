package com.line.birthdaygreetingkata.response.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Birthday Greeting Message List View Object
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class BirthdayGreetingMessageListVO {
    /**
     * Message data
     */
    private List<BirthdayGreetingMessage> birthdayGreetingMessages;
    /**
     * current page number
     */
    private Integer pageNum;
    /**
     * total pages
     */
    private Integer totalPage;
}
