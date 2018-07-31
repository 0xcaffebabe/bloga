package wang.ismy.bloga.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wang.ismy.bloga.dao.inter.IRegion;
import wang.ismy.bloga.dao.repository.RegionRepository;
import wang.ismy.bloga.entity.Region;

@Repository
public class RegionDao {

    @Autowired
    private RegionRepository regionRepository;

   @Autowired
   private IRegion iRegion;

    public Region getRegionById(Integer id){
        return regionRepository.getOne(id);
    }

    public int existByRegion(Region region){
        return iRegion.existByRegion(region);
    }

    public int updateRegion(Region region){
        return iRegion.updateRegion(region);
    }

    public Region insert(Region region) {
        return regionRepository.save(region);
    }
}
