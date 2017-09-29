package com.deemons.aspect_plugin;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * 创建者      chenghaohao
 * 创建时间     2017/9/29 10:19
 * 包名       com.app.plugin
 * 描述
 */
@Aspect
public class AspectDovePlugin {

    @Pointcut("execution(@com.deemons.dove.Dove * *(..))")//方法切入点
    public void methodAnnotated() {
    }


    @Pointcut("execution(@com.deemons.dove.Dove *.new(..))")//构造器切入点
    public void constructorAnnotated() {
    }

    @Around("methodAnnotated()||constructorAnnotated()")
    public Object method(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String canonicalName = methodSignature.getMethod().getDeclaringClass().getCanonicalName();
        String methodName = methodSignature.getName();
        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();//执行原方法
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(canonicalName);
        keyBuilder.append(String.format(" : %s (", methodName));
        for (Object obj : joinPoint.getArgs()) {
            if (obj != null) {
                String format = String.format(Locale.getDefault(), "%s = %s", obj.getClass().getSimpleName(), obj.toString());
                keyBuilder.append(format);
            } else {
                keyBuilder.append("null");
            }
        }
        long during = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
        keyBuilder.append(String.format(Locale.getDefault(), ")   --->:[%d ms]", during));
        Log.d("Dove", (keyBuilder.toString()));// 打印时间差
        return result;
    }


}
