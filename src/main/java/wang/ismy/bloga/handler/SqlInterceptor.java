package wang.ismy.bloga.handler;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import wang.ismy.bloga.entity.SqlLog;
import wang.ismy.bloga.service.SqlLogService;

import javax.persistence.Column;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

@Intercepts({@Signature(type=StatementHandler.class,method="query",args={Statement.class,ResultHandler.class})
,@Signature(type=StatementHandler.class,method="update",args={Statement.class})})
public class SqlInterceptor implements Interceptor {

    @Autowired
    private SqlLogService sqlLogService;
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        var sql=((StatementHandler)invocation.getTarget()).getBoundSql().getSql();

        long start=System.currentTimeMillis();
        var obj=invocation.proceed();
        long end=System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SqlLog sqlLog=new SqlLog();
                sqlLog.setTime(new Date());
                sqlLog.setSentence(sql);
                sqlLog.setDelay((int) (end-start));
                SqlLogService.addLogToQueue(sqlLog);
            }
        }).start();

        return obj;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
