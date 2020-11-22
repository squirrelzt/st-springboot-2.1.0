package com.functional.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Home {
    private Integer id;
    private String username;
    private String name;
    private String mobile;
}
