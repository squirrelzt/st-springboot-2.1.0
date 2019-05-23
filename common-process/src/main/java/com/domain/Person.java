package com.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private String name;

    private String age;

    private String gender;

    private String company;

    private String acctNo;

    private String acctName;
}
