package com.line.birthdaygreetingkata.response;

/**
 * Return status code
 */
public enum ResponseCode {
    /**
     * Successful return status code
     */
    SUCCESS("SUCCESS", "success"),
    /**
     * Default return status codes for all unrecognized exceptions
     */
    SERVICE_ERROR("ERROR", "Server exception");
    /**
     * Status code
     */
    private String code;
    /**
     * Return information
     */
    private String msg;

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}