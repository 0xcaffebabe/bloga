package wang.ismy.bloga.service.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.StayTimeDao;
import wang.ismy.bloga.entity.StayTime;

@Service
public class StayTimeService {

    @Autowired
    private StayTimeDao stayTimeDao;

    public int recordAndGetId(StayTime stayTime){
        return stayTimeDao.recordAndGetId(stayTime);
    }

    public Object updateStatus(Integer id) {
        return stayTimeDao.updateStatus(id);
    }
}
