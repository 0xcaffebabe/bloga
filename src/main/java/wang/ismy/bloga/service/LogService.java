package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.LogDao;
import wang.ismy.bloga.entity.Log;

@Service
public class LogService {

    @Autowired
    private LogDao logDao;

    public Log addLog(Log log){
        return logDao.addLog(log);
    }
}
