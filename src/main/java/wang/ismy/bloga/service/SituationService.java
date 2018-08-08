package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.SituationDao;
import wang.ismy.bloga.entity.Situation;

import java.util.Date;

@Service
public class SituationService {

    @Autowired
    private SituationDao situationDao;

    public Situation add(Situation situation){
        situation.setTime(new Date());
        return situationDao.addSituation(situation);
    }
}
