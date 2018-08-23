package wang.ismy.bloga.dao.inter;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ILog {


    List<Map<String,Object>> getRequestLog();


    List<Map<String,Object>> getStayTimeLog();

    List<Map<String,Object>> getSituationLog();

    List<Map<String,Object>> getSqlLog();
}
