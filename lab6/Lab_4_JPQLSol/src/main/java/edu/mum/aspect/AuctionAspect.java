package edu.mum.aspect;

import edu.mum.domain.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

@Aspect
@Component
public class AuctionAspect {

    //@Pointcut("execution(* edu.mum.service..*(..))")
    //@Pointcut("execution(* edu.mum.service..*(Long))")
    //@Pointcut("execution(* edu.mum.service..*())")
    @Pointcut("within(edu.mum.service..*) && args(user)")
    public void adviceMethod(User user) {}

    //@Before("execution(* edu.mum.service..*(..))")
    @Before("adviceMethod(user)")
    public void Advice(JoinPoint joinPoint, User user) { //, User user
        Logger log = Logger.getLogger("");
        log.info("   **********     TARGET CLASS : " + joinPoint.getSignature().getName() + "    **********");
        System.out.println();
        System.out.println( "   **********     TARGET CLASS : " +
                joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName() +
                "    **********");
    }
}
