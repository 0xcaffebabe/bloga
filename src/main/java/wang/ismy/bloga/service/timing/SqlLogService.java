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

//    往队列中入一条sqlLog
    public SqlLog addLog(SqlLog sqlLog){
        sqlLog.setTime(new Date());
        return sqlLogDao.insert(sqlLog);
    }

//    对外提供的一个添加sqlLog到队列的接口
    public static void addLogToQueue(SqlLog sqlLog){
        synchronized (sqlLogs){
            sqlLogs.push(sqlLog);
        }
    }

    //一个定时从sqlLogs中拉取队列头并进行插入的过程
    @Scheduled(cron = "0/10 * * * * ? ")
    public void addQueue(){

//        每10秒取出队列中的所有sqlLog然后写到数据库
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
