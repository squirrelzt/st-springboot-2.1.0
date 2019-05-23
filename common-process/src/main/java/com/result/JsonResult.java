package com.result;

import com.enums.ResultCodeEnum;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
    private String resultCode;

    private String resultMsg;

    private T data;

    public JsonResult(){}

    public JsonResult(String resultCode, String resultMsg, T data){
        this.resultCode=resultCode;
        this.resultMsg=resultMsg;
        this.data = data;
    }

    public JsonResult(String resultCode, String resultMsg){
        this.resultCode=resultCode;
        this.resultMsg=resultMsg;
    }

    public static <T> JsonResult<T> fail(String code, String msg) {
        return new JsonResult<>(code, msg, null);
    }

    public static <T> JsonResult<T> fail(String msg) {
        return new JsonResult<>(ResultCodeEnum.FAIL.getResultCode(), msg, null);
    }
    public static <T> JsonResult<T> fail(ResultCodeEnum codeEnum,T data) {
        return new JsonResult<>(codeEnum.getResultCode(), codeEnum.getResultMsg(), data);
    }

    public static <T> JsonResult<T> ok(T data) {
        return new JsonResult<T>(ResultCodeEnum.SUCCESS.getResultCode(), ResultCodeEnum.SUCCESS.getResultMsg(), data);
    }

    public static <T> JsonResult<T> timeout(String msg) {
        return new JsonResult<>(ResultCodeEnum.TIME_OUT.getResultCode(), msg, null);
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
