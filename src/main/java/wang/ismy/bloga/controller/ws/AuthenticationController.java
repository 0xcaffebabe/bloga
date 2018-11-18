package wang.ismy.bloga.controller.ws;


import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.bloga.Result;
import wang.ismy.bloga.entity.User;
import wang.ismy.bloga.service.MailService;
import wang.ismy.bloga.service.ws.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@RestController
@RequestMapping(value = "/ws",method = RequestMethod.GET)
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private MailService mailService;

//    认证
    @PostMapping("/auth")
    public Result auth(@RequestParam("user") String user,
                       @RequestParam("salt") String salt, @RequestParam("sign") String sign, HttpServletRequest request){

        //如果认证成功的话，异步发送一封邮件给我
        new Thread(() -> mailService.sendtTextMail("715711877@qq.com",
                "博客后台登录通知","博客后台在"+new Date()+"被"+request.getRemoteAddr()+"登录。")).start();
        return authenticationService.auth(user,salt,sign);
    }

    @PostMapping("/renzheng")
    public Result auth(){
        throw new NullPointerException("Connection is null!");
    }

}
