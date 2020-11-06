package com.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BaseResponseCodeEnums {

    SUCCESS(200, "操作成功"),

    FAIL(400, "操作失败");

    private Integer code;
    private String msg;
}
