package com.line.birthdaygreetingkata.response;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Uniform API Response Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE})
public @interface BaseResponse {

}