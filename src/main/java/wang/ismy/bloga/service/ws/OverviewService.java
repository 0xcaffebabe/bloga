package wang.ismy.bloga.service.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.OverviewDao;

import java.util.HashMap;

@Service
public class OverviewService {

    @Autowired
    private OverviewDao overviewDao;

    public HashMap<String,Integer> getTodayOverview(){
        var map=new HashMap<String,Integer>();
        var list=overviewDao.getTodayOverview();
        map.put("todayRequests",list.get(0));
        map.put("今日访客数",list.get(1));
        map.put("今日页访数",list.get(2));
        map.put("今日阅读数",list.get(3));
        return map;
    }

//    public HashMap<String,Integer> getLastdayOverview(){
//
//    }
}
