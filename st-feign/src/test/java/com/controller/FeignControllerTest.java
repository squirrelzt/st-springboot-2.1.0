package com.controller;

import com.FeignApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;

/**
 * 类名称: FeignControllerTest
 * 类描述: FeignController 测试类
 * @author squirrel
 * @date 2019-04-29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FeignApplication.class)
public class FeignControllerTest {
    @Autowired
    protected WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getData() {
        MockHttpServletRequestBuilder builders = MockMvcRequestBuilders.post(URI.create("/feign/getData"))
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"tom\",\"age\":\"20\",\"gender\":\"male\"}");
        try {
            MvcResult mvcResult = mockMvc.perform(builders).andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();
            Assert.assertEquals(200, response.getStatus());
            Assert.assertEquals("jack", response.getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
