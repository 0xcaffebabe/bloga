package wang.ismy.bloga.dao;

import wang.ismy.bloga.entity.Log;

import java.util.List;

public interface LogDao {
    //获取全部日志
    List<Log> getLogs();
    //新增一条日志
    int addLog(Log log);


}
