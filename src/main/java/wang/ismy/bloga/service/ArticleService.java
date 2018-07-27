package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.constant.ArticleEnum;
import wang.ismy.bloga.dao.ArticleDao;
import wang.ismy.bloga.dao.SettingDao;
import wang.ismy.bloga.entity.Article;
import wang.ismy.bloga.entity.Setting;
import wang.ismy.bloga.exception.ArticleException;

import java.util.*;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Autowired
    private SettingService settingService;
    //新增一篇文章
    public Article addArticle(Article article){
        if(article==null){
            throw new ArticleException(ArticleEnum.ARTICLE_NOT_NULL);
        }else{
            //设置文章的日期
            if(article.getCreateTime()==null){
                article.setCreateTime(new Date());
            }

            if(article.getLastEditTime()==null){
                article.setLastEditTime(new Date());
            }
            return articleDao.addArticle(article);
        }
    }

    //修改一篇文章
    public int updateArticle(Article article){
        if(article==null){
            throw new ArticleException(ArticleEnum.ARTICLE_NOT_NULL);
        }

        if(article.getId()==null){
            throw new ArticleException(ArticleEnum.ARTICLE_ID_NOT_NULL);
        }
        article.setLastEditTime(new Date());
        return articleDao.updateArticle(article);
    }

    //删除一篇文章
    public Object deleteArticle(Integer id){
        if(id==null){
            throw new ArticleException(ArticleEnum.ARTICLE_ID_NOT_NULL);
        }
        return articleDao.deleteArticle(id);
    }
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

    public List<Article> getArticles(){
        return articleDao.getArticles();
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

    //根据file获取文章
    public List<Article> getArticlesByFile(String file,Integer pageNumber){
        if(file==null ||"".equals(file)){
            throw new ArticleException(ArticleEnum.FILE_NOT_NULL);
        }

        int pagingNumber=getArticlesNumberByFile(file);
        if(pageNumber< 1 || pageNumber>pagingNumber){
            throw new ArticleException(ArticleEnum.PAGE_NUMBER_OUT_BOUND);
        }
        int single=settingService.getSinglePageNumber();
        var map=new HashMap<String,Object>();
        map.put("offset",(pageNumber-1)*single);
        map.put("length",single);
        map.put("file",file);
        var list=articleDao.getArticlesByFile(map);
        if(list==null || list.size()==0){
            throw new ArticleException(ArticleEnum.ARTICLE_NOT_EXIST);
        }
        for(var i :list){
            processTagSet(i);
        }
        return list;
    }
    public List<Article> getArticlesBySearch(String keyWord,Integer pageNumber){
        if(keyWord==null ||"".equals(keyWord)){
            throw new ArticleException(ArticleEnum.SEARCH_NOT_NULL);
        }
        int pagingNumber=getArticlesNumberBySearch(keyWord);
        if(pageNumber< 1 || pageNumber>pagingNumber){
            throw new ArticleException(ArticleEnum.PAGE_NUMBER_OUT_BOUND);
        }
        int single=settingService.getSinglePageNumber();
        var map=new HashMap<String,Object>();
        map.put("offset",(pageNumber-1)*single);
        map.put("length",single);
        map.put("keyWord",keyWord);
        var list=articleDao.getArticlesBySearch(map);
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

    //根据归档条件获取文章数量
    public int getArticlesNumberByFile(String file) {
        var i=articleDao.getArticlesNumberByFile(file);
        if(i==0){
            throw new ArticleException(ArticleEnum.FILE_NOT_EXIST);
        }
        return i;
    }
    public int getArticlesNumberByTag(String tag){
        if(tag==null || "".equals(tag)){
            throw new ArticleException(ArticleEnum.ARTICLE_TAG_NOT_NULL);
        }
        return articleDao.getArticlesNumberByTag(tag);
    }
    public int getArticlesNumberBySearch(String keyWord){
        if(keyWord==null || "".equals(keyWord)){
            throw new ArticleException(ArticleEnum.SEARCH_NOT_NULL);
        }
        return articleDao.getArticlesNumberBySearch(keyWord);
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

    //计算归档页分页数
    public int filePagingNumber(String file){
        int single=settingService.getSinglePageNumber();
        int articlesNumber=getArticlesNumberByFile(file);
        if(articlesNumber%single==0 && articlesNumber!=0){
            return (articlesNumber/single);
        }else{
            return articlesNumber/single+1;
        }
    }

    //计算搜索页分页数
    public int searchPagingNumber(String keyWord){
        int single=settingService.getSinglePageNumber();
        int articlesNumber=getArticlesNumberBySearch(keyWord);
        if(articlesNumber%single==0 && articlesNumber!=0){
            return (articlesNumber/single);
        }else{
            return articlesNumber/single+1;
        }
    }


}
