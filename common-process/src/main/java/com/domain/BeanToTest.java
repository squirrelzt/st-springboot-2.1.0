package com.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BeanToTest {

    @JsonProperty("fieldOne")
    private String fieldOne;

    @JsonProperty("fieldTwo")
    private String fieldTwo;

    public String getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(String fieldTwo) {
        this.fieldTwo = fieldTwo;
    }
}
