package com.jackson;

import com.domain.BeanToTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class JacksonBeanNamingKebabTest {

    @Test
    public void testBeanNames() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 为 ObjectMapper 设置全局 PropertyNamingStrategy
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);
        BeanToTest bt = new BeanToTest();
        bt.setFieldOne("field one data.");
        bt.setFieldTwo("field two data.");
        mapper.writeValue(System.out, bt);
    }

    // 为单个类设置 PropertyNamingStrategy 应使用 @JsonNaming
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    private class BeanToTest {
        private String fieldOne;
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
        public void setFieldTwo(String kFieldTwo) {
            this.fieldTwo = kFieldTwo;
        }
    }
}
