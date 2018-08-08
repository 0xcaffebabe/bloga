package wang.ismy.bloga.dao.inter;


import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.Situation;

import java.util.List;

@Mapper
public interface ISituation {

    int isExist(Situation situation);

}
