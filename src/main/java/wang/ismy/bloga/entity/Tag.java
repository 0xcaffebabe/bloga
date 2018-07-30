package wang.ismy.bloga.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Tag extends wang.ismy.bloga.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //标签ID

    @NotEmpty(message = "标签名不得为空")
    private String name; //标签名

    private Date time; //创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
