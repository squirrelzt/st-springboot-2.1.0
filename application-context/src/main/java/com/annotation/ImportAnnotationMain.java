package com.annotation;

import com.domain.Company;
import com.domain.ImportConfig;
import com.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({Person.class, Company.class})
public class ImportAnnotationMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ImportAnnotationMain.class, args);
        System.out.println(context.getBean(Person.class));
        System.out.println(context.getBean(Company.class));
//        context.close();
    }
}
