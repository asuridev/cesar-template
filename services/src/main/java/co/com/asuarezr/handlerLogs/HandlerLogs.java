package co.com.asuarezr.handlerLogs;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class HandlerLogs {

  @Before("@annotation(co.com.asuarezr.handlerLogs.annotations.LogBefore)")
  public void executionBeforeMethod(JoinPoint joinPoint){
    LogManager.getLogger(joinPoint.getSignature().getDeclaringTypeName()).info(
            "Method {} executed with {} arguments",
            joinPoint.getSignature().getName(),
            joinPoint.getArgs()
    );
  }

  @AfterReturning(pointcut = "@annotation(co.com.asuarezr.handlerLogs.annotations.LogAfter)")
  public void executionSuccessMethod(JoinPoint joinPoint){
    LogManager.getLogger(joinPoint.getSignature().getDeclaringTypeName()).info(
            "Method {} executed with {} arguments",
            joinPoint.getSignature().getName(),
            joinPoint.getArgs()
    );
  }

  @AfterThrowing(pointcut = "@annotation(co.com.asuarezr.handlerLogs.annotations.LogExceptions)", throwing = "exception")
  public void executionFailMethod(JoinPoint joinPoint, Exception exception){
    LogManager.getLogger(joinPoint.getSignature().getDeclaringTypeName()).error(
            "Method {} executed with {} arguments throw exception: {}",
            joinPoint.getSignature().getName(),
            joinPoint.getArgs(),
            exception.getClass().getSimpleName()
    );
  }

  @Around("@annotation(co.com.asuarezr.handlerLogs.annotations.LogTimer)")
  public Object executionTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object proceed = joinPoint.proceed();
    long executionTime = System.currentTimeMillis() - start;
    LogManager.getLogger(joinPoint.getSignature().getDeclaringTypeName()).info(
            "Method {} executed in {} ms",
            joinPoint.getSignature().getName(),
            executionTime
    );
    return proceed;
  }


}
