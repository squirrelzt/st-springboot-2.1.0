package com.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 类名称: Course
 * 类描述: 课程
 * @author squirrel
 * @date 2019-09-09
 */
@Data
public class Course {

    /**
     * 用在基本类型上
     */
    @NotNull(message = "id 不能为空")
    private long id;

    /**
     * 用在String上面
     */
    @NotBlank(message = "姓名不能为空")
    private String name;

    /**
     * 用在集合类上面
     */
    @NotEmpty (message = "地址不能为空")
    private List<String> content;

    private Date createDate;

    private Date updateDate;
}
