package com.example.hos.util.common;

import java.io.Serializable;

public class Result<T>  {
    private Long code;

    private String msg;

    private T data;

    protected Result() {
    }

    public Result(Long code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static <T> Result<T> success(){
        return new Result<T>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),null);
    }
    public static <T> Result<T> success(String msg){
        return new Result<T>(ResultEnum.SUCCESS.getCode(),msg,null);
    }
    public static <T> Result<T> success(T data){
        return new Result<T>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),data);
    }
    public static <T> Result<T> success(String msg,T data){
        return new Result<T>(ResultEnum.SUCCESS.getCode(),msg,data);
    }

    public static <T> Result<T> failed(IErrorCode errorCode) {
        return new Result<T>(errorCode.getCode(), errorCode.getMsg(), null);
    }

//    失败
    public static <T> Result<T> failed(String msg){
        return new Result<T>(ResultEnum.ERROR.getCode(),msg,null);
    }
//    服务器失败
    public static <T> Result<T> failed() {
        return failed(ResultEnum.ERROR);
    }
    public static <T> Result<T> valFailed() {
        return failed(ResultEnum.VALIDATE_FAILED);

    }
//验证失败
    public static <T> Result<T> valFailed(String msg) {
        return new Result<T>(ResultEnum.VALIDATE_FAILED.getCode(),msg,null);
    }

    public static <T> Result<T> valFailed(String msg,T data) {
        return new Result<T>(ResultEnum.VALIDATE_FAILED.getCode(),msg,data);
    }
// 未登录
    public static <T> Result<T> unauthorized(T data) {
        return new Result<T>(ResultEnum.UNAUTHORIZED.getCode(), ResultEnum.UNAUTHORIZED.getMsg(), data);
    }

//未授权
    public static <T> Result<T> forbidden(T data) {
        return new Result<T>(ResultEnum.FORBIDDEN.getCode(), ResultEnum.FORBIDDEN.getMsg(), data);
    }

    public static <T> Result<T> forbidden(String msg, T data) {
        return new Result<T>(ResultEnum.FORBIDDEN.getCode(), msg, data);
    }
}
