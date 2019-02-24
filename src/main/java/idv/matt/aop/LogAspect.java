package idv.matt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class.getName());

    @Pointcut("execution(* idv.matt.controller..*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        log.info(getClassMethodName(joinPoint) + " - start");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        log.info(getClassMethodName(joinPoint) + " - end");
    }

    @Pointcut("execution(public * idv.matt.controller..*Api(..))")
    private void controllerPublicMethodPointCut() {
    }

    @Before("controllerPublicMethodPointCut()")
    public void beforeControllerPublicMethod(JoinPoint joinPoint) throws JsonProcessingException {
        String jsonString = getJsonString(joinPoint);
        log.info(jsonString);
    }

    @Pointcut("execution(public * idv.matt.controller..*Api(..))")
    private void afterReturningControllerPublicMethodPointCut() {
    }

    @AfterReturning("afterReturningControllerPublicMethodPointCut()")
    public void afterReturningControllerPublicMethod(JoinPoint joinPoint) throws JsonProcessingException {
        String jsonString = getJsonString(joinPoint);
        log.info(jsonString);
    }
    
    private String getJsonString(JoinPoint joinPoint) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joinPoint.getArgs());
    }

    private String getClassMethodName(JoinPoint joinPoint) {
        return getClassName(joinPoint) + "." + getMethodName(joinPoint);
    }

    private String getClassName(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass().getName();
    }

    private String getMethodName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }
}
