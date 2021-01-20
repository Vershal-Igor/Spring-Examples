package com.example.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

    public static void main(String[] args) {

        /*ApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");*/
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        EmployeeManager manager = context.getBean(EmployeeManager.class);
        EmployeeManagerV2 managerV2 = context.getBean(EmployeeManagerV2.class);

        manager.getEmployeeById(1);
        manager.getAllEmployee();
        managerV2.getAllEmployee();
    }
}
