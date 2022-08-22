package com.cyberandrey.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* com.cyberandrey.dao.*.*(..))")
    public Object aroundAllEmployeeMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("Begin of " + methodName);
        Object targetResult = joinPoint.proceed();
        System.out.println("End of " + methodName);
        return targetResult;
    }
}
