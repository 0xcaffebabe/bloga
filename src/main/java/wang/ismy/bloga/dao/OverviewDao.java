package wang.ismy.bloga.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wang.ismy.bloga.dao.inter.IArticleViewer;
import wang.ismy.bloga.dao.inter.IOverview;

import java.util.List;

@Repository
public class OverviewDao {

    @Autowired
    private IOverview iOverview;

    public List<Integer> getTodayOverview(){
        return iOverview.getTodayOverview();
    }
}
