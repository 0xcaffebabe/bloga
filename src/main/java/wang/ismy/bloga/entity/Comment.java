package wang.ismy.bloga.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Comment extends wang.ismy.bloga.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //评论ID

    private int parentId; //评论父ID

    private int belongArticle; //所属文章ID

    private String name; //评论人昵称

    private String email; //评论人邮箱

    @Column(columnDefinition = "varchar(512)")
    private String content; //评论正文

    private int visible; //评论可见性

    private Date time; //评论时间

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getBelongArticle() {
        return belongArticle;
    }

    public void setBelongArticle(int belongArticle) {
        this.belongArticle = belongArticle;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
