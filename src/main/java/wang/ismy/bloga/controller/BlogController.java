package wang.ismy.bloga.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wang.ismy.bloga.service.ArticleService;

import java.util.Date;

@Controller

@RequestMapping("/")
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("{page}")
    public String index(ModelMap map,@PathVariable("page") Integer page){
        var list=articleService.getArticles(page);
        map.put("articleList",list);
        return "index";
    }
    @GetMapping("")
    public String index1(ModelMap map){
        var list=articleService.getArticles(1);
        map.put("articleList",list);
        return "index";

    }
}
