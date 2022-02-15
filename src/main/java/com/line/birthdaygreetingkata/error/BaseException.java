package com.line.birthdaygreetingkata.error;

import com.line.birthdaygreetingkata.response.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Business Exception
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

    private ResponseCode code;

    public BaseException(ResponseCode code) {
        this.code = code;
    }

    public BaseException(Throwable cause, ResponseCode code) {
        super(cause);
        this.code = code;
    }
}