package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.RegionDao;
import wang.ismy.bloga.dao.repository.RegionRepository;
import wang.ismy.bloga.entity.Region;

import java.util.LinkedList;
import java.util.List;


@Service
public class RegionService {

    @Autowired
    private RegionDao regionDao;

    //一个缓存队列
    private static final List<Region> regionQueue=new LinkedList<>();


    public void updateRegion(Region region){
        //读取数据库，判断相应的region是否存在
        if(regionDao.existByRegion(region)!=0){
            //更新
             regionDao.updateRegion(region);
        }else{
            //插入
//            region.setCount(0);
//            synchronized (regionQueue){
//                regionQueue.add(region);
//                //如果队列
//            }

            regionDao.insert(region);
        }
    }
}
