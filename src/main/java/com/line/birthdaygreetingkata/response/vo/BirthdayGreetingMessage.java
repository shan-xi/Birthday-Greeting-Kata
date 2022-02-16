package com.line.birthdaygreetingkata.response.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Birthday Greeting Message Object
 */
@Data
@AllArgsConstructor
public class BirthdayGreetingMessage {
    /**
     * Email Subject
     */
    private String title;
    /**
     * Email Content
     */
    private String content;
}
