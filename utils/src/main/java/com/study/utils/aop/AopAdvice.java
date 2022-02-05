package com.study.utils.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAdvice {

    @Pointcut("execution(* com.study.utils.aop.AopTest.test(..))")
    public void pt1() {
    }

    @Around("pt1()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("begin");
            result = joinPoint.proceed();
            System.out.println("after");
        } catch (Throwable e) {
            System.out.println("Throwable");
        } finally {
            System.out.println("finally");
        }
        return result;
    }

}
