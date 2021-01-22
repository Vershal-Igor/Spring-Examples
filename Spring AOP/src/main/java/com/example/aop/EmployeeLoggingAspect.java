package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeLoggingAspect {

    //point-cut expression
    @Before("execution(* com.example.aop.EmployeeManager.getEmployeeById(..))")
    public void logBeforeGetEmployeeById(JoinPoint joinPoint) {
        System.out.println(
                "EmployeeLoggingAspect.logBeforeGetEmployeeById() : " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.example.aop.EmployeeManager.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
        System.out.println("****LoggingAspect.logAfterThrowingAllMethods() " + ex);
    }

    @Before("execution(public * getAllEmployee())")
    public void logBeforeGetAllEmployee(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getName() +
                " EmployeeLoggingAspect.logBeforeGetAllEmployee() : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.example.aop.EmployeeManager.*(..))")
    public void logBeforeEachEmployeeManagerMethod(JoinPoint joinPoint) {
        System.out.println(
                "EmployeeLoggingAspect.logBeforeEachEmployeeManagerMethod() : "
                        + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.aop.EmployeeManager.getEmployeeById(..))")
    public void logAfterGetEmployeeById(JoinPoint joinPoint) {
        System.out.println(
                "EmployeeLoggingAspect.logAfterGetEmployeeById() : " + joinPoint.getSignature().getName());
    }
}
