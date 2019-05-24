package com.controller;

import com.CommonProcessApplication;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.domain.Person;
import com.enums.ResultCodeEnum;
import com.result.JsonResult;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonProcessApplication.class)
public class PersonControllerTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void listPersons() {
        MockHttpServletRequestBuilder builders = MockMvcRequestBuilders.post(URI.create("/person/queryAll"))
                .contentType(MediaType.APPLICATION_JSON)
                .content("");
        try {
            MvcResult mvcResult = mockMvc.perform(builders).andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();
            Assert.assertEquals(200, response.getStatus());
            String content = response.getContentAsString();
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPersonByName() {
        MockHttpServletRequestBuilder builders = MockMvcRequestBuilders.post(URI.create("/person/queryByName"))
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"squirrel\"}");
        try {
            MvcResult mvcResult = mockMvc.perform(builders).andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();
            Assert.assertEquals(200, response.getStatus());
            String content = response.getContentAsString();
            JsonResult<Person> jsonResult = JSON.parseObject(content, new TypeReference<JsonResult<Person>>(){});
            System.out.println("content" + content);
            if (ResultCodeEnum.SUCCESS.getResultCode().equals(jsonResult.getResultCode())) {
                Person person = jsonResult.getData();
                System.out.println(JSON.toJSONString(person));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
