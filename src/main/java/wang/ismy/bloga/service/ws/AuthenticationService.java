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

//    认证接口
    public Result auth(String userName, String salt, String sign){

        /*
        * 原理说明：
        * 首先，外部会传入用户名、随机数以及签名(签名由用户名+加密过的密码+随机数加密而成)
        * 从数据库根据用户名取得加密过后的密码，并且使用传入的前两个参数进行加密
        * 把加密过后的结果与传进来的sign进行比对，若相符，则返回token给用户
        * （注意：加密的时候务必注意大小写问题）
        * */
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
            result.setMessage("认证成功");
            result.setStatus(200);
            //生成token
            //如果缓存中有，就直接从缓存中获取
            String token=null;
            if(cacheService.isExist("token")){
                token=cacheService.get("token").toString();
            }else{
                token=createToken(md5);
                cacheService.set("token",token,1800);
            }
            result.setData(token);
            CacheService.cachePool.put(token,user);
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
