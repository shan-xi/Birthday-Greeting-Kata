package com.line.birthdaygreetingkata.advice;

import com.line.birthdaygreetingkata.error.BaseException;
import com.line.birthdaygreetingkata.response.BaseResponse;
import com.line.birthdaygreetingkata.response.ResponseCode;
import com.line.birthdaygreetingkata.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Custom Exception Handler
 */
@ControllerAdvice(annotations = BaseResponse.class)
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {
    /**
     * Checked Exception handler
     *
     * @param e
     * @return ResponseResult
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getCode(), ResponseCode.SERVICE_ERROR.getMsg(), null);
    }

    /**
     * Unchecked Exception Handler
     *
     * @param e
     * @return ResponseResult
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getCode(), ResponseCode.SERVICE_ERROR.getMsg(), null);
    }

    /**
     * Business Exception Handler
     *
     * @param e
     * @return ResponseResult
     */
    @ExceptionHandler(BaseException.class)
    public ResponseResult handleBaseException(BaseException e) {
        log.error(e.getMessage(), e);
        ResponseCode code = e.getCode();
        return new ResponseResult(code.getCode(), code.getMsg(), null);
    }
}