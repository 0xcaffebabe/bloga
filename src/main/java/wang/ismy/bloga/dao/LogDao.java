package wang.ismy.bloga.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.ismy.bloga.dao.inter.ILog;
import wang.ismy.bloga.dao.repository.LogRepository;
import wang.ismy.bloga.entity.Log;

import java.util.List;

@Component
public class LogDao {

    @Autowired
    private LogRepository repository;
    @Autowired
    private ILog log;

    //获取全部日志
    List<Log> getLogs(){
        return repository.findAll();
    }
    //新增一条日志
    Log addLog(Log log){
        return repository.save(log);
    }


}
