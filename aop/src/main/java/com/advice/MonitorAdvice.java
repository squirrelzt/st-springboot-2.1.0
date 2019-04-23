package com.advice;

import com.monitor.MonitorSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class MonitorAdvice {
    @Pointcut("execution (* com.service.Speakable.*(..))")
    public void pointcut() {
    }
    @Around("pointcut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        MonitorSession.begin(pjp.getSignature().getName());
        pjp.proceed();
        MonitorSession.end();
    }
}
