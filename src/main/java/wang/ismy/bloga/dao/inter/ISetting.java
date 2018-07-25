package wang.ismy.bloga.dao.inter;

import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.Setting;

@Mapper
public interface ISetting {

    Setting getSettingByKey(String key);

    int deleteSettingById(int id);

    int deleteSettingByKey(String key);

    int updateSetting(Setting setting);
}
