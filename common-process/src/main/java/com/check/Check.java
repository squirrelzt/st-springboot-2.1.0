package com.check;

import com.enums.ResultCodeEnum;
import com.result.JsonResult;

public class Check {
    public static  <T> void checkResultParam(JsonResult<T> param) {
        //如果返回码不是成功码，直接返回码
        Asserts.isTrue(ResultCodeEnum.isSuccess(param.getResultCode()),param.getResultCode(),param.getResultMsg());
    }
}
