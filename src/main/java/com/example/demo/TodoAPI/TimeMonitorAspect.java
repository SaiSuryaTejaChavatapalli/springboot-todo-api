package com.example.demo.TodoAPI;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public Object logtime(ProceedingJoinPoint joinPoint)  throws  Throwable {
        Object result=null;
        long start = System.currentTimeMillis();

        try{
           result= joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Something went wrong during the execution");
            throw e;
        } finally {
            long end = System.currentTimeMillis();

            long total=end-start;

            System.out.println("Total time of execution of this method is "+ total+" ms..");
        }

        return  result;
    }
}
