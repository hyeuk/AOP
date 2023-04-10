package start.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class Aspect7 {

    @Around("start.aop.order.aop.Pointcuts.allOrder()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("log -> {}",joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
