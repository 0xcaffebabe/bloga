package wang.ismy.bloga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.entity.Article;
import wang.ismy.bloga.entity.Tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//对博客左侧的那些内容进行了封装
@Service
public class EdgeService {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;
    public List<Tag> getTags(){
        return tagService.getTags();
    }

//    获取相关文章
    public List<Article> getRelevantArticles(Integer articleId){
        return  articleService.getRelevantArticles(articleId);
    }

//    推荐文章
    public List<Article> getRecommendArticles(){
        return articleService.getRecommendArticles();
    }

//    归档类目
    public List<String> getFile(){
        return articleService.getFile();
    }


//    获取边缘那块东西的显示模型
    public Map<String,Object> getEdge(Integer articleId){
        System.err.println("now articleId:"+articleId);
        var map=new HashMap<String,Object>();
        map.put("relevantArticles",articleService.getRelevantArticles(articleId));
        map.put("recommendArticles",articleService.getRecommendArticles());
        map.put("tagList",tagService.getTags());
        map.put("fileList",articleService.getFile());
        return map;
    }
}
