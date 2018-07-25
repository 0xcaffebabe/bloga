package wang.ismy.bloga.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.ismy.bloga.dao.inter.ISetting;
import wang.ismy.bloga.dao.repository.SettingRepository;
import wang.ismy.bloga.entity.Setting;

import java.util.List;

@Component
public class SettingDao {

    @Autowired
    private SettingRepository repository;

    @Autowired
    private ISetting iSetting;

    //获取全部设置
    List<Setting> getSettings(){
        return repository.findAll();
    }
    //根据key获取设置
    Setting getSettingByKey(String key){
        return iSetting.getSettingByKey(key);
    }
    //新增一设置
    Setting addSetting(Setting setting){
        return repository.save(setting);
    }
    //根据ID删除设置
    int deleteSettingById(int id){
        return iSetting.deleteSettingById(id);
    }
    //根据key删除设置
    int deleteSettingByKey(String key){
        return iSetting.deleteSettingByKey(key);
    }

    int updateSetting(Setting setting){
        return iSetting.updateSetting(setting);
    }
}
