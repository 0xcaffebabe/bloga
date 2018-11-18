package wang.ismy.bloga.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Comment extends wang.ismy.bloga.entity.Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //评论ID

    private Integer parentId; //评论父ID

    @NotNull(message = "所属文章ID不能为空")
    private Integer belongArticle; //所属文章ID

    @NotEmpty(message = "昵称不能为空")
    private String name; //评论人昵称

    @NotEmpty(message = "邮箱不能为空")
    private String email; //评论人邮箱

    @NotEmpty(message = "评论正文不能为空")
    @Column(columnDefinition = "varchar(512)")
    private String content; //评论正文

    private Integer visible; //评论可见性

    private Date time; //评论时间

    public Integer getId() {
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

    public Integer getVisible() {
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

    public Integer getBelongArticle() {
        return belongArticle;
    }

    public void setBelongArticle(int belongArticle) {
        this.belongArticle = belongArticle;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
