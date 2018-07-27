package wang.ismy.bloga.handler;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.ismy.bloga.service.ArticleService;
import wang.ismy.bloga.service.EdgeService;

import java.util.Map;

/*
* 用来记录每一个controller的请求
* */
@Component
@Aspect
public class GlobalControllerAspect {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private EdgeService edgeService;

    @Pointcut("execution(* wang.ismy.bloga.controller..*.*(..))")
    public void pointCut(){

    }

    @Pointcut("@annotation(wang.ismy.bloga.annotation.BlogEdge)")
    public void edgePointCut(){

    }

    @Before("edgePointCut()")
    public void before(JoinPoint point){
        long start=System.currentTimeMillis();
        Map modalMap=null;
        int articleId=-1;
        //通过这个循环来取出切入点函数的两个参数：1.modalMap、2.articleId
        for(var i:point.getArgs()){
            try{
                var t=(Map)i;
                modalMap=t;
            }catch (Exception e){
                try {
                    var t=(Integer)i;
                    articleId=t;
                } catch (Exception e1) {

                }
            }
        }

        if(modalMap==null){

        }else{
            //在这里把edge这个东西添加到modalMap里
            modalMap.put("edge",edgeService.getEdge(articleId));
        }
        long end=System.currentTimeMillis();

        System.err.println("执行"+point.getTarget().getClass().getName()+"的"+point.getSignature().getName()+"方法(before),耗时:"+
                (end-start)+"ms");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) {
        long start=System.currentTimeMillis();
        Object object= null;
        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        long end=System.currentTimeMillis();
        System.err.println("执行"+point.getTarget().getClass().getName()+"的"+point.getSignature().getName()
        +"方法,耗时:"+(end-start)+"ms");
        return object;
    }


}
