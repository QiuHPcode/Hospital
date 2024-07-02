package com.example.hos.util.common;

public interface IErrorCode {

    long getCode();

    /**
     * 返回结果信息
     *
     * @return 结果信息
     */
    String getMsg();
}
