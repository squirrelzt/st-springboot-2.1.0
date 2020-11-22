package com.functional.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    private Integer id;
    private String username;
    private String name;
    private String mobile;
    private List<String> roles;
}
