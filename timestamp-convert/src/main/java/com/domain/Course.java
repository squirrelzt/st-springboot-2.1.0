package com.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Course {

    private long id;

    private String name;

    private Date createDate;

    private Date updateDate;
}
