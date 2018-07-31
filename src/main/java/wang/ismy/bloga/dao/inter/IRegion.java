package wang.ismy.bloga.dao.inter;

import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.Region;

@Mapper
public interface IRegion {

    int existByRegion(Region region);

    int updateRegion(Region region);
}
