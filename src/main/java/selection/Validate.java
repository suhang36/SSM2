package selection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class Validate {
  @Pointcut("execution(* Service.impl.StudentServiceImpl.*(..))")
  public void setName(){}

  @Before("setName()")
  public void login(){
  System.out.println("登陆成功");
  }
  @After("setName()")
  public void writeLog(){
  System.out.println("登陆时间:"+new Date().toLocaleString());
  }

  public Object run(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("环绕通知开始");
    Object res=null;
    try {
      res=joinPoint.proceed();
    }catch (RuntimeException e){
      e.printStackTrace();
    }
    System.out.println("环绕通知结束");
    return res;
  }
}