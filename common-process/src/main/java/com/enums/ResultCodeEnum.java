package com.enums;

/**
 * 类名称: ApiResultCodeEnum
 * 类描述: api返回码枚举类
 * @author squirrel
 * @date 2019-05-23
 */
public enum ResultCodeEnum {
    /**
     * 请求成功
     */
    SUCCESS("请求成功","000000"),

    /**
     * 请求失败
     */
    FAIL("请求失败","999999"),

    /**
     *
     */
    TIME_OUT("请求超时", "100001"),

    ;
    private String resultMsg;
    private String resultCode;

    ResultCodeEnum(String resultMsg, String resultCode) {
        this.resultCode=resultCode;
        this.resultMsg =resultMsg;
    }
    public String getResultCode() {
        return resultCode;
    }
    public String getResultMsg() {
        return resultMsg;
    }

    /***
     * 是否超时
     * @param code
     * @return
     */
    public static boolean isTimeout(String code){
        return TIME_OUT.resultCode.equals(code);
    }

    public static boolean isFail(String code){
        return FAIL.resultCode.equals(code);
    }

    public static boolean isSuccess(String code){
        return SUCCESS.resultCode.equals(code);
    }
}
