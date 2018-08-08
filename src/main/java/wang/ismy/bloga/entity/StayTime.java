package wang.ismy.bloga.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class StayTime  extends wang.ismy.bloga.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //每次停留记录ID

    private String ip; //停留记录IP

    private Integer residenceTime; //停留时间

    private Date time; //停留记录创建时间

    @Column(columnDefinition = "varchar(2048)")
    private String url; //受访URL

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getResidenceTime() {
        return residenceTime;
    }

    public void setResidenceTime(Integer residenceTime) {
        this.residenceTime = residenceTime;
    }
}
