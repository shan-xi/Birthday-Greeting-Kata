package com.line.birthdaygreetingkata.error;

import com.line.birthdaygreetingkata.response.ResponseCode;

/**
 * Member Exception
 */
public class MemberException extends BaseException {
    public MemberException(ResponseCode code) {
        super(code);
    }

    public MemberException(Throwable cause, ResponseCode code) {
        super(cause, code);
    }
}
