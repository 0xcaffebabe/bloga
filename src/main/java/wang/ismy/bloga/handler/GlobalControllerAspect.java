package wang.ismy.bloga.handler;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.ismy.bloga.service.ArticleService;
import wang.ismy.bloga.service.EdgeService;
import wang.ismy.bloga.service.LogService;
import wang.ismy.bloga.service.StatisticsService;

import java.util.Map;

/*
* 用来记录每一个controller的请求
* */
@Component
@Aspect
public class GlobalControllerAspect {

    @Autowired
    private LogService logService;

    @Autowired
    private EdgeService edgeService;

    @Autowired
    private StatisticsService statisticsService;

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

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) {
        //如果请求第一个参数是map类型，就注入footer这个玩意
        if(point.getArgs().length==0){

        }else{
            try{
                var t=(Map)point.getArgs()[0];
                t.put("footer",statisticsService.getVisitorsStatistics());
            }catch (Exception e){

            }

        }

        Object object= null;
        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        }


        return object;
    }


}
