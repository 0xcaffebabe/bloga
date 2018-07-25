package wang.ismy.bloga.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ismy.bloga.entity.Article;
import wang.ismy.bloga.service.SettingService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleDaoTest {

    @Autowired
    private ArticleDao dao;

    @Autowired
    private SettingService settingService;
    @Test
    @Ignore
    public void getArticles() {
        List<Article> articleList=dao.getArticles();
        assertEquals(1,articleList.size());
    }

    @Test
    @Ignore
    public void getArticleById() {
        Article article=dao.getArticleById(1);
        assertEquals("一个标题",article.getTitle());
    }

    @Test
    public void deleteArticle() {
        assertEquals(1,dao.deleteArticle(5));
    }

    @Test
    public void updateArticle() {
        Article article=new Article();
        article.setId(4);
        article.setTitle("设置成这个标题");
        article.setLastEditTime(new Date());
        assertEquals(1,dao.updateArticle(article));
    }

    @Test
    @Ignore
    public void addArticle() {
        Article article=new Article();
        article.setTitle("第二标题"+new Date());
        article.setContent("第二内容"+new Date());
        article.setTags("1,5,6");
        System.out.println("123");
        article.setCreateTime(new Date());
        article.setLastEditTime(new Date());
        article= dao.addArticle(article);
        assertEquals("1,5,6",article.getTags());
    }

    @Test
    public void getArticlesByPage() {
        var map=new HashMap<String,Object>();
        map.put("offset", (1-1)*settingService.getSinglePageNumber());
        map.put("length",settingService.getSinglePageNumber());
        List<Article> a= dao.getArticlesByPage(map);
        System.out.println(a.get(1).getUserName());
    }
}