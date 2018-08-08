package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.StatisticsDao;

import java.util.HashMap;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsDao statisticsDao;

    public HashMap<String,Object> getVisitorsStatistics(){
        var t=statisticsDao.getVisitorsStatistics();
        var ret=new HashMap<String,Object>();
        for(var i:t){
            ret.put(i.get("name").toString(),i.get("COUNT(DISTINCT ip)"));
        }
        return ret;
    }
}
