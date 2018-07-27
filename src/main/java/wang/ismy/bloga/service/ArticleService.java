package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.constant.ArticleEnum;
import wang.ismy.bloga.dao.ArticleDao;
import wang.ismy.bloga.dao.SettingDao;
import wang.ismy.bloga.entity.Article;
import wang.ismy.bloga.entity.Setting;
import wang.ismy.bloga.exception.ArticleException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Autowired
    private SettingService settingService;
    //用ID来获取文章
    public Article getArticleById(Integer id){
        var article=articleDao.getArticleById(id);
        if(article==null){
            throw new ArticleException(ArticleEnum.ARTICLE_NOT_EXIST);
        }
        article.setTagSet(Set.of(article.getTags().split(",")));
        return article;
    }
    //根据页数获取文章
    public List<Article> getArticles(Integer pageNumber){
        int paggingNumber=indexPagingNumber();
        if(pageNumber==null){
            pageNumber=1;
        }else if(pageNumber<1 || pageNumber>paggingNumber){
            throw new ArticleException(ArticleEnum.PAGE_NUMBER_OUT_BOUND);
        }
        //设置分页相关参数
        var map=new HashMap<String,Object>();
        int single=settingService.getSinglePageNumber();
        map.put("offset",(pageNumber-1)*single);
        map.put("length",single);
        var ret=articleDao.getArticlesByPage(map);
        //对tags进行分割，并将其存储到tagSet
        for(var i:ret){
            i.setTagSet(Set.of(i.getTags().split(",")));
        }
        return ret;
    }

//    根据文章ID获取（相关）文章
    public List<Article> getRelevantArticles(Integer articleId){
        if(articleId==null || articleId<1){
            articleId=-1;
        }
        var map=new HashMap<String,Object>();
        map.put("articleId",articleId);
        map.put("length",settingService.getEdgeArticleNumber());
        return articleDao.getRelevantArticles(map);
    }

    //获取推荐文章
    public List<Article> getRecommendArticles(){
        return articleDao.getRecommendArticles(settingService.getEdgeArticleNumber());
    }

    //根据tag获取文章
    /*
    * @param tag 欲被寻找的标签
    * @param pageNumber 页数
    * */
    public List<Article> getArticlesByTag(String tag,Integer pageNumber){
        var pagingNumber=getArticlesNumberByTag(tag);
        var singlePageNumber=settingService.getSinglePageNumber();
        if(pageNumber==null){
            pageNumber=1;
        }
        if(tag==null || "".equals(tag)){
            throw new ArticleException(ArticleEnum.ARTICLE_TAG_NOT_NULL);
        }else if(pageNumber<1 || pageNumber>pagingNumber){
            throw new ArticleException(ArticleEnum.PAGE_NUMBER_OUT_BOUND);
        }
        var map=new HashMap<String,Object>();
        map.put("tag",tag);
        map.put("offset",(pageNumber-1)*singlePageNumber);
        map.put("length",singlePageNumber);
        var list=articleDao.getArticlesByTag(map);
        if(list==null || list.size()==0){
            throw new ArticleException(ArticleEnum.ARTICLE_NOT_EXIST);
        }
        for(var i :list){
            processTagSet(i);
        }
        return list;
    }
    //获取归档结果
    public List<String> getFile(){
        return articleDao.getFile();
    }

    public long getArticlesNumber(){
        return articleDao.getArticlesNumber();
    }

    public int getArticlesNumberByTag(String tag){
        if(tag==null || "".equals(tag)){
            throw new ArticleException(ArticleEnum.ARTICLE_TAG_NOT_NULL);
        }
        return articleDao.getArticlesNumberByTag(tag);
    }

    //处理tagset
    public void processTagSet(Article article){
        article.setTagSet(Set.of(article.getTags().split(",")));
    }
    //计算首页分页数
    public int indexPagingNumber(){
        int single=settingService.getSinglePageNumber();
        long articlesNumber=getArticlesNumber();
        if(articlesNumber%single==0 && articlesNumber!=0){
            return (int) (articlesNumber/single);
        }else{
            return (int) (articlesNumber/single)+1;
        }
    }

    //计算标签分类页分页数
    public int tagPagingNumber(String tag){
        int single=settingService.getSinglePageNumber();
        int articlesNumber=getArticlesNumberByTag(tag);
        if(articlesNumber%single==0 && articlesNumber!=0){
            return (articlesNumber/single);
        }else{
            return (articlesNumber/single)+1;
        }
    }
}
