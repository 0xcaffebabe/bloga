package wang.ismy.bloga.dao.inter;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IOverview {

    List<Integer> getTodayOverview();
}
