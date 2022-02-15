package com.line.birthdaygreetingkata.advice;

import com.line.birthdaygreetingkata.response.BaseResponse;
import com.line.birthdaygreetingkata.response.ResponseCode;
import com.line.birthdaygreetingkata.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Uniform API Response Handler
 */
@ControllerAdvice(annotations = BaseResponse.class)
@Slf4j
public class ResponseResultHandlerAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response) {
        if (MediaType.APPLICATION_JSON.equals(selectedContentType)) {
            if (body instanceof ResponseResult) {
                return body;
            } else {
                return new ResponseResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), body);
            }
        }
        return body;
    }
}