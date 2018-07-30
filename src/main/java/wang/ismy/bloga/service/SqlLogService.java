package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.SqlLogDao;
import wang.ismy.bloga.entity.SqlLog;

import java.util.*;

@Service
public class SqlLogService {
    public static LinkedList<SqlLog> sqlLogs=new LinkedList<>();

    @Autowired
    private SqlLogDao sqlLogDao;

    public SqlLog addLog(SqlLog sqlLog){
        sqlLog.setTime(new Date());
        return sqlLogDao.insert(sqlLog);
    }

    public static void addLogToQueue(SqlLog sqlLog){
        synchronized (sqlLogs){
            sqlLogs.push(sqlLog);
            System.out.println("sqllog队列:"+sqlLogs);
        }

    }
}
