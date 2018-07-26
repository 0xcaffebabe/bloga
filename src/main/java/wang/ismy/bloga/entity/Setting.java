package wang.ismy.bloga.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Setting extends wang.ismy.bloga.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //设置ID

    private String SettingKey; //设置索引

    private String SettingValue; //设置内容

    private String remarks; //备注

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSettingKey() {
        return SettingKey;
    }

    public void setSettingKey(String settingKey) {
        SettingKey = settingKey;
    }

    public String getSettingValue() {
        return SettingValue;
    }

    public void setSettingValue(String settingValue) {
        SettingValue = settingValue;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
