package com.line.birthdaygreetingkata.response.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * Birthday Greeting Message List Xml View Object
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
@JacksonXmlRootElement(localName = "root")
public class BirthdayGreetingMessageListXmlVO implements Serializable {
    /**
     * Message data
     */
    @JacksonXmlProperty(localName = "message")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<BirthdayGreetingMessage> simpleMessages;
}
