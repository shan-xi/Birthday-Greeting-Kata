package com.line.birthdaygreetingkata.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Uniform API Response
 */
@Data
@AllArgsConstructor
public class ResponseResult implements Serializable {
    /**
     * Return status code
     */
    private String code;
    /**
     * Return information
     */
    private String msg;
    /**
     * body data
     */
    private Object data;

}