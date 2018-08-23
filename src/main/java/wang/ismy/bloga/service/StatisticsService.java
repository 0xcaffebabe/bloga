package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.StatisticsDao;

import java.util.HashMap;
import java.util.List;

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

    public List<String> getOnlineUser(){

        var list=statisticsDao.getOnlineUser();

        for(var i=0;i<list.size();i++){
           var tmp=list.get(i);
           tmp=tmp.replace(tmp.substring(tmp.lastIndexOf("."),tmp.length()),".*");
           list.set(i,tmp);
        }
        return list;
    }
}
