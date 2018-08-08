package wang.ismy.bloga.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Situation extends wang.ismy.bloga.entity.Entity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //异常ID

    @Column(columnDefinition = "varchar(1024)")
    private String msg; //异常信息

    @Column(columnDefinition = "text")
    private String stack; //异常跟踪栈

    private Date time;//异常发生时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
