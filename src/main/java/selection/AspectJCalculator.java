package selection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Aspect
@Component
public class AspectJCalculator {
    //定义一个切入点
    @Pointcut("execution(* Service.impl.CalculatorImpl.*(..))")
    public void setName(){}
    //前置通知
   @Before("setName()")
    public void before(JoinPoint join) throws InterruptedException {
       Thread.sleep(2000);
       String name=join.getSignature().getName();
       List<Object> args = Arrays.asList(join.getArgs());
       System.out.println("Before:开始方法: "+name);
       args.forEach(System.out::println);
    }
//    //环绕通知
//    @Around("setName()")
//    public Object around (ProceedingJoinPoint joinPoint){
//        System.out.println("around:开始执行："+joinPoint.getSignature().getName());
//        Object result = null;
//        try {
//            result=joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println("执行结束"+joinPoint.getSignature().getName());
//        return result;
//    }
}
