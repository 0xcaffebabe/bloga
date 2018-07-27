package wang.ismy.bloga.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wang.ismy.bloga.annotation.BlogEdge;
import wang.ismy.bloga.entity.Article;
import wang.ismy.bloga.service.ArticleService;
import wang.ismy.bloga.util.PagingUtils;

import java.util.Date;

@Controller

@RequestMapping("/")
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("{page}")
    @BlogEdge
    public String index(ModelMap map,@PathVariable("page") Integer page){
        var list=articleService.getArticles(page);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.indexPagingNumber(),page));
        return "index";
    }

    @GetMapping("")
    @BlogEdge
    public String index1(ModelMap map){
        var list=articleService.getArticles(1);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.indexPagingNumber(),1));
        return "index";

    }
    @GetMapping("/article/{articleId}")
    @BlogEdge
    public String article(ModelMap map,@PathVariable("articleId") Integer id){
        Article article=articleService.getArticleById(id);
        map.put("article",article);
        return "article";
    }

    @GetMapping("/tag/{name}/{pageNumber}")
    @BlogEdge
    public String tag(ModelMap map,@PathVariable("name") String tag,@PathVariable(value = "pageNumber") Integer pageNumber){
        var list=articleService.getArticlesByTag(tag,pageNumber);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.tagPagingNumber(tag),pageNumber,"tag/"+tag));
        return "index";
    }

    @GetMapping("/tag/{name}")
    @BlogEdge
    public String tag1(ModelMap map,@PathVariable("name") String tag){
        var list=articleService.getArticlesByTag(tag,1);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.tagPagingNumber(tag),1,"tag/"+tag));
        return "index";
    }
}
