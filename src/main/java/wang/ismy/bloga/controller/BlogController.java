package wang.ismy.bloga.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class BlogController {

    @GetMapping("/")
    public String index(ModelMap map){
        map.put("date",new Date());
        return "index";
    }
}
