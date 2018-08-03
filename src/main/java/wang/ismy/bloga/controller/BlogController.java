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

    //处理首页分页
    @GetMapping("/{page}")
    @BlogEdge
    public String index(ModelMap map,@PathVariable("page") Integer page){
        var list=articleService.getArticles(page);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.indexPagingNumber(),page));
        map.put("webTitle","博客首页");
        map.put("h1Title","近期文章第"+page+"页");
        return "index";
    }
    //处理默认首页
    @GetMapping("")
    @BlogEdge
    public String index1(ModelMap map){
        var list=articleService.getArticles(1);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.indexPagingNumber(),1));
        map.put("webTitle","博客首页");
        map.put("h1Title","近期文章第"+1+"页");
        return "index";

    }
    //处理文章页
    @GetMapping("/article/{articleId}")
    @BlogEdge
    public String article(ModelMap map,@PathVariable("articleId") Integer id){
        Article article=articleService.getArticleById(id);
        map.put("article",article);
        map.put("webTitle",article.getTitle());
        return "article";
    }
    //处理标签分类页分页
    @GetMapping("/tag/{name}/{pageNumber}")
    @BlogEdge
    public String tag(ModelMap map,@PathVariable("name")
            String tag,@PathVariable(value = "pageNumber") Integer pageNumber){
        var list=articleService.getArticlesByTag(tag,pageNumber);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.tagPagingNumber(tag),pageNumber,"tag/"+tag));
        map.put("webTitle","标签"+tag);
        map.put("h1Title","标签"+tag+"第"+pageNumber+"页");
        return "index";
    }
    //默认标签分类页
    @GetMapping("/tag/{name}")
    @BlogEdge
    public String tag1(ModelMap map,@PathVariable("name") String tag){
        var list=articleService.getArticlesByTag(tag,1);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.tagPagingNumber(tag),1,"tag/"+tag));
        map.put("webTitle","标签"+tag);
        map.put("h1Title","标签"+tag+"第"+1+"页");
        return "index";
    }

    //处理归档页分页
    @GetMapping("/file/{file}/{pageNumber}")
    @BlogEdge
    public String file(ModelMap map,@PathVariable("file")
            String file,@PathVariable(value = "pageNumber") Integer pageNumber){
        map.put("articleList",articleService.getArticlesByFile(file,pageNumber));
        map.put("paging",PagingUtils.calcPages(articleService.filePagingNumber(file),pageNumber,"file/"+file));
        map.put("webTitle","归档"+file);
        map.put("h1Title","归档"+file+"第"+pageNumber+"页");
        return "index";
    }

    //默认归档页
    @GetMapping("/file/{file}")
    @BlogEdge
    public String file1(ModelMap map,@PathVariable("file")
            String file){
        map.put("articleList",articleService.getArticlesByFile(file,1));
        map.put("paging",PagingUtils.calcPages(articleService.filePagingNumber(file),1,"file/"+file));
        map.put("webTitle","归档"+file);
        map.put("h1Title","归档"+file+"第"+1+"页");
        return "index";
    }

    //处理搜索页分页
    @GetMapping("/search/{keyWord}/{pageNumber}")
    @BlogEdge
    public String search(ModelMap map,@PathVariable("keyWord")
            String keyWord,@PathVariable(value = "pageNumber") Integer pageNumber){
        map.put("articleList",articleService.getArticlesBySearch(keyWord,pageNumber));
        map.put("paging",PagingUtils.calcPages(articleService.searchPagingNumber(keyWord),pageNumber,"search/"+keyWord));
        map.put("webTitle","搜索"+keyWord);
        map.put("h1Title","搜索"+keyWord+"第"+pageNumber+"页");
        return "index";
    }

    //默认搜索页
    @GetMapping("/search/{keyWord}")
    @BlogEdge
    public String search1(ModelMap map,@PathVariable("keyWord")
            String keyWord){
        map.put("articleList",articleService.getArticlesBySearch(keyWord,1));
        map.put("paging",PagingUtils.calcPages(articleService.searchPagingNumber(keyWord),1,"search/"+keyWord));
        map.put("webTitle","搜索"+keyWord);
        map.put("h1Title","搜索"+keyWord+"第"+1+"页");
        return "index";
    }

    @GetMapping("/myadmin")
    public String backEnd(){
        return "/myadmin/index.html";
    }


}
