package wang.ismy.bloga.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;
@Entity
public class Log extends wang.ismy.bloga.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//日志ID

    private String ip;//来访者IP

    @Column(columnDefinition = "varchar(2048)")
    private String url;//被访问的URL

    @Column(columnDefinition ="varchar(1024)")
    private String ua;//来访者的UA头

    private Date time; //访问时间

    private int delay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
