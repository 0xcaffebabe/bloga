package wang.ismy.bloga.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import wang.ismy.bloga.BlogaApplication;
import wang.ismy.bloga.dao.inter.IArticle;
import wang.ismy.bloga.dao.repository.ArticleRepository;
import wang.ismy.bloga.entity.Article;

import java.util.List;
import java.util.Map;

@Component
public class ArticleDao  {


    @Autowired
    private ArticleRepository repository;

    @Autowired
    private IArticle iArticle;

    //获取全部文章
    public List<Article> getArticles(){
        return repository.findAll();
    }
    //分页获取文章
    public List<Article> getArticlesByPage(Map<String,Object> map){
        return iArticle.getArticlesByPage(map);
    }
    //根据ID获取文章
    public Article getArticleById(int id){
        return repository.getOne(id);
    }
    //删除文章
    public int deleteArticle(int id){
        return iArticle.deleteArticle(id);
    }
    //更新文章
    public int updateArticle(Article article){
       return iArticle.updateArticle(article);
    }
    //新增文章
    public Article addArticle(Article article){
        return repository.save(article);
    }
}
