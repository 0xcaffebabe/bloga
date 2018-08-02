package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.constant.SettingEnum;
import wang.ismy.bloga.dao.SettingDao;
import wang.ismy.bloga.entity.Setting;
import wang.ismy.bloga.exception.SettingException;

import java.util.List;

@Service
public class SettingService {

    @Autowired
    private SettingDao settingDao;

    //获取每一页所能容纳的元素数量
    public int getSinglePageNumber(){
        var number=settingDao.getSettingByKey("SINGLE_PAGE_NUMBER");
        int ret=SettingEnum.DEFAULT_SINGLE_PAGE_NUMBER.getCode();
        if(number==null){
            return ret;
        }else{
            try {
                ret=Integer.parseInt(number.getSettingValue());
            }catch (Exception e){

            }
        }
        return ret;
    }

    //获取边缘文章展示数量
    public int getEdgeArticleNumber(){
        var number=settingDao.getSettingByKey("EDGE_ARTICLE_NUMBER");
        int ret=SettingEnum.DEFAULT_EDGE_ARTICLE_NUMBER.getCode();
        if(number==null){
            return ret;
        }else{
            try{
                ret=Integer.parseInt(number.getSettingValue());
            }catch (Exception e){

            }
        }
        return ret;

    }

    public List<Setting> getSettings(){
        return settingDao.getSettings();
    }

    public Setting addSetting(Setting setting) {
        return settingDao.addSetting(setting);
    }

    public int updateSetting(Setting setting) {
        if(setting==null){
            throw new NullPointerException();
        }

        if(setting.getId()==null){
            throw new SettingException(SettingEnum.ID_NOT_NULL);
        }
        return settingDao.updateSetting(setting);
    }

    public Setting getSettingByKey(String key){
        //如果key可以被转为整数的话
        int id;
        try{
            id=Integer.parseInt(key);
            return getSettingById(id);
        }catch (Exception e){

        }
        return settingDao.getSettingByKey(key);
    }

    public Setting getSettingById(Integer id){
        return settingDao.getSettingById(id);
    }

    public int deleteSettingByKey(String key){return settingDao.deleteSettingByKey(key);}

    public List<Setting> getSettingBySearch(String keyWord) {
        return settingDao.getSettingBySearch(keyWord);
    }

    public int deleteSettingBatch(List<Integer> idList) {
        return settingDao.deleteSettingBatch(idList);
    }
}
