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
        return articleService.addArticle(article);
    }

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
}
