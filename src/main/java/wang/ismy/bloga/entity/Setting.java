package wang.ismy.bloga.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Setting extends wang.ismy.bloga.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //设置ID

    @NotEmpty(message = "索引不得为空")
    private String settingKey; //设置索引

    @NotEmpty(message = "内容不得为空")
    private String settingValue; //设置内容

    private String remarks; //备注

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }
}
