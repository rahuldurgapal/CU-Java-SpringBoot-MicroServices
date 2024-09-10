package com.example.AopApplication.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.example.aopdemo.service.UserProfileService.*(..))")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("Method " + methodName + " called with arguments: ");
        for (Object arg : args) {
            System.out.println("    " + arg);
        }

        Object result = joinPoint.proceed();

        System.out.println("Method " + methodName + " returned: " + result);

        return result;
    }
}
