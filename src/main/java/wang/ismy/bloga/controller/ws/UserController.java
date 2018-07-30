package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.service.UserService;

@RestController
@RequestMapping("/ws/user")
public class UserController {


    @Autowired
    private UserService userService;
    @GetMapping("")
    @Token
    public Object getUsers(@RequestParam("token") String token){
        return userService.getUsers();
    }
}
