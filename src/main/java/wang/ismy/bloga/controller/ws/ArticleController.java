package wang.ismy.bloga.controller.ws;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.bloga.Result;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.entity.Article;
import wang.ismy.bloga.service.ArticleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ws/article")

public class ArticleController {


    @Autowired
    private ArticleService articleService;
    //获取所有文章
    @GetMapping("")
    @Token
    public Object getAllArticles(@RequestParam("token") String token){
        return articleService.getArticles();
    }

    //搜索获取文章
    @GetMapping("/search")
    @Token
    public Object getArticleBySearch(@RequestParam("token") String token,@RequestParam("pageNumber") Integer pageNumber,
                                     @RequestParam("pagingNumber") Integer pagingNumber, @RequestParam("keyWord") String keyWord){
        return articleService.getArticlesBySearch(keyWord,pageNumber,pagingNumber);
    }

    //获取文章分页数
    @GetMapping("/paging")
    @Token
    public Object getArticlePaging(@RequestParam("token") String token,@RequestParam("pageNumber") Integer pageNumber,
                                  @RequestParam("pagingNumber") Integer pagingNumber){

        return articleService.indexPagingNumber(pagingNumber);
    }

    //获取搜索文章分页数
    @GetMapping("/search/paging")
    @Token
    public Object getArticlePagingBySearch(@RequestParam("token") String token,@RequestParam("pageNumber") Integer pageNumber,
                                  @RequestParam("pagingNumber") Integer pagingNumber, @RequestParam("keyWord") String keyWord){

        return articleService.searchPagingNumber(keyWord,pagingNumber);
    }

    //分页获取所有文章
    @GetMapping("/page")
    @Token
    public Object getArticlesByPage(@RequestParam("token") String token,@RequestParam("pageNumber") Integer pageNumber,
                                    @RequestParam("pagingNumber") Integer pagingNumber){
        return articleService.getArticles(pageNumber,pagingNumber);
    }
    //根据ID来获取文章
    @GetMapping("/{id}")
    @Token
    public Object getArticleById(@RequestParam("token") String token,
                                 @PathVariable("id") Integer id){
        return articleService.getArticleById(id);
    }

    @PutMapping("")
    @Token
    public Object addArticle(@RequestParam("token") String token,
                             @RequestBody @Valid Article article){

                return articleService.addArticle(token,article);
    }

    //修改文章
    @PostMapping("")
    @Token
    public Object modifyArticle(@RequestParam("token") String token,
                                @RequestBody  Article article){
        return articleService.updateArticle(article);
    }

    @DeleteMapping("/{id}")
    @Token
    public Object deleteArticle(@RequestParam("token") String token, @PathVariable("id") Integer id){
        return articleService.deleteArticle(id);
    }

    //批量删除文章
    @DeleteMapping("")
    @Token
    public Object deleteArticleBatch(@RequestParam("token") String token,@RequestBody List<Integer> idList){
        return articleService.deleteArticleBatch(idList);
    }
}
