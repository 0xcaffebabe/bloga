package wang.ismy.bloga.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wang.ismy.bloga.annotation.BlogEdge;
import wang.ismy.bloga.entity.Article;
import wang.ismy.bloga.service.ArticleService;
import wang.ismy.bloga.service.SettingService;
import wang.ismy.bloga.util.PagingUtils;
import wang.ismy.bloga.util.TextUtils;

import java.util.Date;

@Controller

@RequestMapping("/")
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SettingService settingService;

    private String siteTitle;

    private String keyWord;

    private String description;

    private String siteSideLine;



    public void init(){
        siteTitle=settingService.getSettingByKey("site-title")
                ==null?"博客首页":settingService.getSettingByKey("site-title").getSettingValue();

        keyWord=settingService.getSettingByKey("site-keyWord")==null
                ?"":settingService.getSettingByKey("site-keyWord").getSettingValue();

        description=settingService.getSettingByKey("site-description")==null
                ?"":settingService.getSettingByKey("site-description").getSettingValue();

        siteSideLine=settingService.getSettingByKey("site-sideLine")==null
                ?"":settingService.getSettingByKey("site-sideLine").getSettingValue();
    }
    //处理首页分页
    @GetMapping("/{page}")
    @BlogEdge
    public String index(ModelMap map,@PathVariable("page") Integer page){
        init();
        var list=articleService.getArticles(page);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.indexPagingNumber(),page));
        map.put("webTitle",siteTitle);
        map.put("h1Title","近期文章第"+page+"页");
        map.put("keyWord",keyWord);
        map.put("description",description);
        return "index";
    }
    //处理默认首页
    @GetMapping("")
    @BlogEdge
    public String index1(ModelMap map){
        init();
        var list=articleService.getArticles(1);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.indexPagingNumber(),1));
        map.put("webTitle",siteTitle);
        map.put("h1Title","近期文章第"+1+"页");
        map.put("keyWord",keyWord);
        map.put("description",description);
        return "index";

    }
    //处理文章页
    @GetMapping("/article/{articleId}")
    @BlogEdge
    public String article(ModelMap map,@PathVariable("articleId") Integer id){
        init();
        Article article=articleService.getArticleById(id);
        map.put("article",article);
        map.put("webTitle",article.getTitle()+" - "+siteSideLine);
        map.put("keyWord",keyWord+","+article.getTags());
        map.put("description",TextUtils.Html2Text(article.getContent()));
        return "article";
    }
    //处理标签分类页分页
    @GetMapping("/tag/{name}/{pageNumber}")
    @BlogEdge
    public String tag(ModelMap map,@PathVariable("name")
            String tag,@PathVariable(value = "pageNumber") Integer pageNumber){
        init();
        var list=articleService.getArticlesByTag(tag,pageNumber);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.tagPagingNumber(tag),pageNumber,"tag/"+tag));
        map.put("webTitle","标签"+tag+" - "+siteSideLine);
        map.put("h1Title","标签"+tag+"第"+pageNumber+"页");
        map.put("keyWord",keyWord);
        map.put("description",description);
        return "index";
    }
    //默认标签分类页
    @GetMapping("/tag/{name}")
    @BlogEdge
    public String tag1(ModelMap map,@PathVariable("name") String tag){
        init();
        var list=articleService.getArticlesByTag(tag,1);
        map.put("articleList",list);
        map.put("paging",PagingUtils.calcPages(articleService.tagPagingNumber(tag),1,"tag/"+tag));
        map.put("webTitle","标签"+tag+" - "+siteSideLine);
        map.put("h1Title","标签"+tag+"第"+1+"页");
        map.put("keyWord",keyWord);
        map.put("description",description);
        return "index";
    }

    //处理归档页分页
    @GetMapping("/file/{file}/{pageNumber}")
    @BlogEdge
    public String file(ModelMap map,@PathVariable("file")
            String file,@PathVariable(value = "pageNumber") Integer pageNumber){
        init();
        map.put("articleList",articleService.getArticlesByFile(file,pageNumber));
        map.put("paging",PagingUtils.calcPages(articleService.filePagingNumber(file),pageNumber,"file/"+file));
        map.put("webTitle","归档"+file+" - "+siteSideLine);
        map.put("h1Title","归档"+file+"第"+pageNumber+"页");
        map.put("keyWord",keyWord);
        map.put("description",description);
        return "index";
    }

    //默认归档页
    @GetMapping("/file/{file}")
    @BlogEdge
    public String file1(ModelMap map,@PathVariable("file")
            String file){
        init();
        map.put("articleList",articleService.getArticlesByFile(file,1));
        map.put("paging",PagingUtils.calcPages(articleService.filePagingNumber(file),1,"file/"+file));
        map.put("webTitle","归档"+file+" - "+siteSideLine);
        map.put("h1Title","归档"+file+"第"+1+"页");
        map.put("keyWord",keyWord);
        map.put("description",description);
        return "index";
    }

    //处理搜索页分页
    @GetMapping("/search/{keyWord}/{pageNumber}")
    @BlogEdge
    public String search(ModelMap map,@PathVariable("keyWord")
            String keyWord,@PathVariable(value = "pageNumber") Integer pageNumber){
        init();
        map.put("articleList",articleService.getArticlesBySearch(keyWord,pageNumber));
        map.put("paging",PagingUtils.calcPages(articleService.searchPagingNumber(keyWord),pageNumber,"search/"+keyWord));
        map.put("webTitle","搜索"+keyWord+" - "+siteSideLine);
        map.put("h1Title","搜索"+keyWord+"第"+pageNumber+"页");
        map.put("keyWord",keyWord);
        map.put("description",description);
        return "index";
    }

    //默认搜索页
    @GetMapping("/search/{keyWord}")
    @BlogEdge
    public String search1(ModelMap map,@PathVariable("keyWord")
            String keyWord){
        init();
        map.put("articleList",articleService.getArticlesBySearch(keyWord,1));
        map.put("paging",PagingUtils.calcPages(articleService.searchPagingNumber(keyWord),1,"search/"+keyWord));
        map.put("webTitle","搜索"+keyWord+" - "+siteSideLine);
        map.put("h1Title","搜索"+keyWord+"第"+1+"页");
        map.put("keyWord",keyWord);
        map.put("description",description);
        return "index";
    }

    @GetMapping("/myadmin")
    public String backEnd(){
        return "/myadmin/index.html";
    }

    //蜘蛛爬取规则
    @RequestMapping("/robots.txt")
    public @ResponseBody String robots(){
        return settingService.getSettingByKey("site-robots").getSettingValue();
    }

    @GetMapping("/about")
    public String about(ModelMap map){
        init();
        map.put("webTitle","关于"+" - "+siteSideLine);
        map.put("about",settingService.getSettingByKey("site-about").getSettingValue());
        map.put("keyWord",keyWord);
        map.put("description",description);
        return "about";
    }

    @GetMapping("/contact")
    public String contact(ModelMap map){
        init();
        map.put("webTitle","联系"+" - "+siteSideLine);
        map.put("contact",settingService.getSettingByKey("site-contact").getSettingValue());
        map.put("keyWord",keyWord);
        map.put("description",description);
        return "contact";
    }

}
