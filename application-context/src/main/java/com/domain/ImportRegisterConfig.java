package com.domain;

import com.bean.MyBeanDefinitionRegistrat;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyBeanDefinitionRegistrat.class)
public class ImportRegisterConfig {
}
