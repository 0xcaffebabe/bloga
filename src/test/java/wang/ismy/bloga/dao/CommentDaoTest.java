package wang.ismy.bloga.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ismy.bloga.entity.Comment;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoTest {

    @Autowired
    private CommentDao dao;
    @Test
    @Ignore
    public void getComments() {
        List<Comment> comments=dao.getComments();
        assertEquals(2,comments.size());
    }

    @Test
    @Ignore
    public void getCommentByArticleId() {
        Comment comment=dao.getCommentByArticleId(1);
        assertEquals("715711877@qq.com",comment.getEmail());
    }

    @Test
    @Ignore
    public void deleteComment() {
        assertEquals(1,dao.deleteComment(1));
    }

    @Test
    public void updateComment() {
        Comment comment=new Comment();
        comment.setId(3);
        comment.setEmail("264968583@qq.com");
        assertEquals(1,dao.updateComment(comment));
    }

    @Test
    @Ignore
    public void addComment() {
        Comment comment=new Comment();
        comment.setBelongArticle(12);
        comment.setContent("内容");
        comment.setEmail("admin@qq.com");
        comment.setName("admin1");
        comment.setParentId(0);
        comment.setTime(new Date());
        comment.setVisible(-1);
        comment=dao.addComment(comment);
        assertEquals("admin@qq.com",comment.getEmail());
    }
}