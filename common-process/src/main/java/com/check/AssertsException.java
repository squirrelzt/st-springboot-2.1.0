package com.check;


import com.enums.ResultCodeEnum;

public class AssertsException extends RuntimeException {
    private String code;

    public String getCode() {
        return code == null ? ResultCodeEnum.FAIL.getResultCode() : code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AssertsException() {
        super();
    }

    public AssertsException(String message) {
        super(message);
        setCode(ResultCodeEnum.FAIL.getResultCode());
    }

    public AssertsException(String message, Throwable cause) {
        super(message, cause);
    }


    public AssertsException(ResultCodeEnum codeEnum){
        super(codeEnum.getResultMsg());
        setCode(codeEnum.getResultCode());
    }

    public AssertsException(String code,String message){
        super(message);
        setCode(code);
    }
}
