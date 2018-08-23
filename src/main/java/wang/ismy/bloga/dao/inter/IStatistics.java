package wang.ismy.bloga.dao.inter;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IStatistics {

    public List<Map<String,Object>> getVisitorsStatistics();

    List<String> getOnlineUser();
}
