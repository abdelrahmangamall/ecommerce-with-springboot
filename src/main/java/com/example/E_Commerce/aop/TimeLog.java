package com.example.E_Commerce.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLog {
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Before(value = "execution(* com.example.E_Commerce.service.*.*(..))")
    public void getStartTime(){
        startTime.set(System.currentTimeMillis());
    }

    @After(value = "execution(* com.example.E_Commerce.service.*.*(..))")
    public void calcDurationTime(JoinPoint joinPoint){
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime.get();

        System.out.println("The Duration Time Of Method: "+ joinPoint.getSignature().getName()+
                " Is: "+ duration+ "ms");
    }
}