package wang.ismy.bloga.service;


import org.apache.http.util.TextUtils;
import org.hibernate.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.constant.SettingEnum;
import wang.ismy.bloga.dao.SettingDao;
import wang.ismy.bloga.entity.Setting;
import wang.ismy.bloga.exception.SettingException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class SettingService {

    @Autowired
    private SettingDao settingDao;

    @Autowired
    private CacheService cacheService;

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

//    获取所有设置
    public List<Setting> getSettings(){
        return settingDao.getSettings();
    }

//    增加设置
    public Setting addSetting(Setting setting) {
        return settingDao.addSetting(setting);
    }

//    更新设置
    public int updateSetting(Setting setting) {
        if(setting==null){
            throw new NullPointerException();
        }

        if(setting.getId()==null){
            throw new SettingException(SettingEnum.ID_NOT_NULL);
        }
        return settingDao.updateSetting(setting);
    }

//    根据key获取设置
    public Setting getSettingByKey(String key){
        //如果缓存中有key
        if(cacheService.isExist(key)){
            return (Setting) cacheService.get(key);
        }

        //如果key可以被转为整数的话
        Setting ret;
        int id;

        ret=settingDao.getSettingByKey(key);
        //加入缓存
        cacheService.set(key,ret,60);
        return ret;
    }

//    根据ID获取设置
    public Setting getSettingById(Integer id){
        return settingDao.getSettingById(id);
    }

//    根据key删除设置
    public int deleteSettingByKey(String key){return settingDao.deleteSettingByKey(key);}

//    搜索设置
    public List<Setting> getSettingBySearch(String keyWord) {
        return settingDao.getSettingBySearch(keyWord);
    }

//    根据ID列表批量删除设置
    public int deleteSettingBatch(List<Integer> idList) {
        return settingDao.deleteSettingBatch(idList);
    }

    //批量更新
    public int updateBatch(Map<String,String> map){
        Set<String> keySet=map.keySet();
        var i=keySet.iterator();
        while (i.hasNext()){
            //如果根据这个key取不到对应的setting，则创建
            var t=i.next();
            var older=getSettingByKey(t);
            if(older==null){
                var s=new Setting();
                s.setSettingKey(t);
                s.setSettingValue(map.get(t));
                addSetting(s);
            }else{
                //否则就更新对应的内容
                older.setSettingValue(map.get(t));
                updateSetting(older);
            }
        }
        return 1;
    }


//    获取网站设置
    public Map<String,String> siteSetting() {
        var maps=settingDao.siteSetting();
        var map=new HashMap<String,String>();
        for(var i:maps){
            map.put(i.get("setting_key"),i.get("setting_value"));
        }
        return map;

    }
}
