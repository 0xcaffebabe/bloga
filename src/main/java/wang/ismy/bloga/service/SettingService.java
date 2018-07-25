package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.constant.SettingEnum;
import wang.ismy.bloga.dao.SettingDao;

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


}
