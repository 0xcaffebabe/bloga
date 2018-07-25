package wang.ismy.bloga.dao;

import wang.ismy.bloga.entity.Setting;

import java.util.List;

public interface SettingDao {
    //获取全部设置
    List<Setting> getSettings();
    //根据key获取设置
    Setting getSettingByKey(String key);
    //新增一设置
    int addSetting(Setting setting);
    //根据ID删除设置
    int deleteSettingById(int id);
    //根据key删除设置
    int deleteSettingByKey(String key);
}
