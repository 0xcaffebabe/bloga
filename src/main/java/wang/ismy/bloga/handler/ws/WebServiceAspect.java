package wang.ismy.bloga.handler.ws;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wang.ismy.bloga.Result;
import wang.ismy.bloga.service.CacheService;

@Component
@Aspect
public class WebServiceAspect {

    @Autowired
    private CacheService cacheService;

    @Pointcut("@annotation(wang.ismy.bloga.annotation.Token)")
    public void tokenAuth(){}


    @Around("tokenAuth()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println(point.getThis().getClass().getName());
        var token=(String)point.getArgs()[0];
        if(token.equals(cacheService.get("token"))){
            Result result=new Result();
            result.setMessage("操作完成");
            result.setStatus(200);
            result.setData(point.proceed());
            return result;
        }else{
            Result result=new Result();
            result.setMessage("没有经过授权");
            result.setStatus(403);
            result.setData(null);
            return result;
        }

    }
}
