package com.line.birthdaygreetingkata.response.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Birthday Greeting Message View Object
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class BirthdayGreetingMessage implements Serializable {
    /**
     * Email Subject
     */
    @JacksonXmlProperty(localName = "title")
    private String title;
    /**
     * Email Content
     */
    @JacksonXmlProperty(localName = "content")
    private String content;
}
