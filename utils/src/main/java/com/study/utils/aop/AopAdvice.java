package com.study.utils.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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

    @Pointcut("@annotation(com.study.utils.aop.AopAnnotation)")
    public void annotation() {
    }

    @Before("annotation()")
    public void before(JoinPoint joinPoint) {
        System.out.println("joinPoint.getArgs() = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("joinPoint.getKind() = " + joinPoint.getKind());
        System.out.println("joinPoint.getSignature() = " + joinPoint.getSignature());
        System.out.println("joinPoint.getSourceLocation() = " + joinPoint.getSourceLocation());
        System.out.println("joinPoint.getStaticPart() = " + joinPoint.getStaticPart());
        System.out.println("joinPoint.getThis() = " + joinPoint.getThis());
    }

    @AfterReturning(value = "annotation()", returning = "result")
    public void afterReturning(Object result) {
        if (result instanceof Integer integer) {
            System.out.println("integer = " + integer + 1);
        }
    }

}
