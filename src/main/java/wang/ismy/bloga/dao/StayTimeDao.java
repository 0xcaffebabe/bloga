package wang.ismy.bloga.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wang.ismy.bloga.dao.inter.IStayTime;
import wang.ismy.bloga.dao.repository.StayTimeRepository;
import wang.ismy.bloga.entity.StayTime;

@Repository
public class StayTimeDao {

    @Autowired
    private StayTimeRepository stayTimeRepository;


    @Autowired
    private IStayTime iStayTime;
    public int recordAndGetId(StayTime stayTime){
        return stayTimeRepository.save(stayTime).getId();
    }

    public Object updateStatus(Integer id) {
        return iStayTime.updateStatus(id);
    }
}
