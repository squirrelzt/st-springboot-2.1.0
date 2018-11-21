package com.annotation;

import com.domain.ImportConfig;
import com.domain.ImportRegisterConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanDefinitionMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ImportConfig.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext(ImportRegisterConfig.class);
        String[] beanDefinitionNames = ((AnnotationConfigApplicationContext) context).getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }
}
