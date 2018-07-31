package wang.ismy.bloga.service.timing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
        }
    }

    //一个定时从sqlLogs中拉取队列头并进行插入的过程
    @Scheduled(cron = "0/10 * * * * ? ")
    public void addQueue(){

        synchronized (sqlLogs){
            List<SqlLog> list=new ArrayList<>();
            while(true){
                try{
                    list.add(sqlLogs.pop());
                }catch (Exception e){
                    break;
                }

            }
            if(list.size()==0){

            }else{
                sqlLogDao.insertBatch(list);
            }



        }

    }


}
