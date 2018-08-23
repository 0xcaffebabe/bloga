package wang.ismy.bloga.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.ismy.bloga.dao.inter.ILog;
import wang.ismy.bloga.dao.repository.LogRepository;
import wang.ismy.bloga.entity.Log;
import wang.ismy.bloga.entity.Situation;
import wang.ismy.bloga.entity.StayTime;

import java.util.List;
import java.util.Map;

@Component
public class LogDao {

    @Autowired
    private LogRepository repository;
    @Autowired
    private ILog log;

    //获取全部日志
    public List<Log> getLogs(){
        return repository.findAll();
    }
    //新增一条日志
    public Log addLog(Log log){
        return repository.save(log);
    }


    public List<Map<String,Object>> getRequestLog() {
        return log.getRequestLog();
    }

    public List<Map<String,Object>> getStayTimeLog() {
        return log.getStayTimeLog();
    }

    public List<Map<String,Object>> getSituationLog() {

        return log.getSituationLog();
    }

    public List<Map<String,Object>> getSqlLog() {
        return log.getSqlLog();
    }
}
