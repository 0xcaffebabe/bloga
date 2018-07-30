package wang.ismy.bloga.service.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import wang.ismy.bloga.Result;
import wang.ismy.bloga.constant.UserEnum;
import wang.ismy.bloga.exception.AuthenticationException;
import wang.ismy.bloga.service.CacheService;
import wang.ismy.bloga.service.UserService;

import java.util.Random;

@Service
public class AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private CacheService cacheService;
    public Result auth(String userName, String salt, String sign){
        var user=userService.getUserByName(userName);
        if(user==null){
            throw new AuthenticationException(UserEnum.AUTH_FAILED);
        }
        String i=userName+user.getPassword().toUpperCase()+salt;
        i=i.toUpperCase();
        String md5=DigestUtils.md5DigestAsHex(i.getBytes());
        if(md5.equals(sign)){
            //返回token
            Result result=new Result();
            result.setMsg("认证成功");
            result.setStatus(200);
            //生成token
            var token=createToken(md5);
            cacheService.set("token",token);
            result.setData(token);
            return result;
        }else{
            //抛出身份认证失败异常
            throw new AuthenticationException(UserEnum.AUTH_FAILED);
        }
    }

    private String createToken(String sign){
        Random random=new Random();
        sign+=sign+random.nextLong();
        return DigestUtils.md5DigestAsHex(sign.getBytes());
    }
}
