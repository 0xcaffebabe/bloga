package wang.ismy.bloga.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wang.ismy.bloga.dao.inter.IStatistics;

import java.util.List;
import java.util.Map;

@Repository
public class StatisticsDao {


    @Autowired
    private IStatistics iStatistics;
    public List<Map<String,Object>> getVisitorsStatistics(){
        return iStatistics.getVisitorsStatistics();
    }

    public List<String> getOnlineUser() {
        return iStatistics.getOnlineUser();
    }
}
