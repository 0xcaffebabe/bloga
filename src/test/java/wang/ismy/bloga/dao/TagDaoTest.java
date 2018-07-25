package wang.ismy.bloga.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ismy.bloga.entity.Tag;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagDaoTest {


    @Autowired
    private TagDao dao;
    @Test
    @Ignore
    public void getTags() {
        List<Tag> list=dao.getTags();
        assertEquals(2,list.size());
    }

    @Test
    public void getTagsByArticleId() {

    }

    @Test
    public void deleteTag() {
        assertEquals(1,dao.deleteTag(1));
    }

    @Test
    public void updateTag() {
        Tag tag=new Tag();
        tag.setId(2);
        tag.setName("html5");
        assertEquals(1,dao.updateTag(tag));
    }

    @Test
    @Ignore
    public void addTag() {
        Tag tag=new Tag();
        tag.setName("java");
        tag.setTime(new Date());
        assertEquals("java",dao.addTag(tag).getName());
    }
}