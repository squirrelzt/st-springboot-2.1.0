package com.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class MockPerson implements Serializable {

    private String name;

    private String age;

    private String gender;

    private String school;

    private String account;

    private String accountName;
}
