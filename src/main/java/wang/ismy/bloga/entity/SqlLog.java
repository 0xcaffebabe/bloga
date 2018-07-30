package wang.ismy.bloga.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class SqlLog  extends wang.ismy.bloga.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //日志ID


    @Column(columnDefinition = "varchar(2048)")
    private String sentence; //SQL语句

    private Date time; //语句执行时间

    private Integer delay; //语句耗时

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}
