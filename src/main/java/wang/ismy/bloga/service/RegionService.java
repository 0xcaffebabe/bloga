package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.RegionDao;
import wang.ismy.bloga.dao.repository.RegionRepository;
import wang.ismy.bloga.entity.Region;


@Service
public class RegionService {

    @Autowired
    private RegionDao regionDao;


    public void updateRegion(Region region){
        //读取数据库，判断相应的region是否存在
        if(regionDao.existByRegion(region)!=0){
            //更新
             regionDao.updateRegion(region);
        }else{
            //插入
            region.setCount(0);
            regionDao.insert(region);
        }
    }
}
