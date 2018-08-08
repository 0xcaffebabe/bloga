package wang.ismy.bloga.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wang.ismy.bloga.dao.inter.ISituation;
import wang.ismy.bloga.dao.repository.SituationRepoisory;
import wang.ismy.bloga.entity.Situation;

@Repository
public class SituationDao {


    @Autowired
    private ISituation iSituation;

    @Autowired
    private SituationRepoisory situationRepoisory;
    public Situation addSituation(Situation situation){
        if(iSituation.isExist(situation)==0){
            return situationRepoisory.save(situation);
        }else{
            return situation;
        }
    }


}
