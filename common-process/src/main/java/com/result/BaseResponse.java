package com.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> BaseResponse<T> ok() {
        return new BaseResponse(BaseResponseCodeEnums.SUCCESS.getCode(), BaseResponseCodeEnums.SUCCESS.getMsg(), null);
    }

    public static <T> BaseResponse<T> fail(String msg) {
        return new BaseResponse<>(BaseResponseCodeEnums.FAIL.getCode(), msg, null);
    }
    public static <T> BaseResponse<T> fail(Integer code, String msg) {
        return new BaseResponse<>(code, msg, null);
    }


}
