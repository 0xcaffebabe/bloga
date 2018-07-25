package wang.ismy.bloga.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.bloga.Result;
import wang.ismy.bloga.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @GetMapping("/login")
    public Result login(@RequestParam("name") String name,@RequestParam("password") String password){
        Result ret=new Result();
        ret.setData(service.isAdmin(name,password));
        return ret;
    }
}
