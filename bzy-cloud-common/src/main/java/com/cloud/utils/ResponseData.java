package com.cloud.utils;

import cn.hutool.core.util.IdUtil;

/**
 * 返回给前台的通用包装
 */
public class ResponseData<T> {

    public static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";

    public static final String DEFAULT_ERROR_MESSAGE = "网络异常";

    public static final String DEFAULT_FAIL_MESSAGE = "请求失败";

    public static final Integer DEFAULT_SUCCESS_CODE = 200;

    public static final Integer DEFAULT_ERROR_CODE = 500;

    public static final Integer DEFAULT_FEIGN_ERROR_CODE = 499;

    public static final Integer DEFAULT_UNAUTH_CODE = 401;

    public static final Integer DEFAULT_FORBIDDEN_CODE = 403;


    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应对象
     */
    private T data;

    /**
     * 请求id
     */
    private String requestId;

    public ResponseData() {
    }

    public ResponseData(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.requestId= IdUtil.getSnowflakeNextIdStr();
    }

    public static <T> ResponseData<T> success(T t) {
        return new ResponseData<T>(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, t);
    }

    public static <T> ResponseData<T> success(T t, String message) {
        return new ResponseData<T>(true, DEFAULT_SUCCESS_CODE, message, t);
    }

    public static <T> ResponseData<T> success(Integer code, String message) {
        return new ResponseData<T>(true, code, message, null);
    }

    public static <T> ResponseData<T> success(String message) {
        return new ResponseData<T>(true, DEFAULT_SUCCESS_CODE, message, null);
    }

    public static <T> ResponseData<T> error(String message) {
        return new ResponseData<T>(false, DEFAULT_ERROR_CODE, message, null);
    }

    public static <T> ResponseData<T> feignError(String message) {
        return new ResponseData<T>(false, DEFAULT_FEIGN_ERROR_CODE, message, null);
    }

    public static <T> ResponseData<T> error(Integer code, String message) {
        return new ErrorResponseData(code, message);
    }

    public static ErrorResponseData error(Integer code, String message, Object object) {
        return new ErrorResponseData(code, message, object);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
