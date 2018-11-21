package com.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Person.class, Company.class})
public class ImportConfig {
}
