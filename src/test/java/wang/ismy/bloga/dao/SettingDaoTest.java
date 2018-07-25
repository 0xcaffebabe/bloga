package wang.ismy.bloga.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ismy.bloga.entity.Setting;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SettingDaoTest {

    @Autowired
    private SettingDao dao;
    @Test
    @Ignore
    public void getSettings() {
        List<Setting> settingList=dao.getSettings();
        assertEquals(2,settingList.size());
    }

    @Test
    @Ignore
    public void getSettingByKey() {
        assertEquals("50",dao.getSettingByKey("page").getSettingValue());
    }

    @Test
    @Ignore
    public void addSetting() {
        Setting setting=new Setting();
        setting.setSettingKey("title");
        setting.setSettingValue("word");
        assertEquals("title",dao.addSetting(setting));
    }


    @Test
    public void getSettings1() {
    }

    @Test
    public void getSettingByKey1() {
    }

    @Test
    public void addSetting1() {
    }

    @Test
    public void deleteSettingById1() {
    }

    @Test
    public void deleteSettingByKey1() {
    }

    @Test
    public void updateSetting() {
        Setting setting=new Setting();
        setting.setId(4);
        setting.setSettingKey("ismy");
        assertEquals(1,dao.updateSetting(setting));
    }
}