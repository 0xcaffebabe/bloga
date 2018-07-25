package wang.ismy.bloga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.constant.UserEnum;
import wang.ismy.bloga.dao.UserDao;
import wang.ismy.bloga.entity.User;
import wang.ismy.bloga.exception.UserException;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    //判断传进来的账号与用户名是否与后台对应得上
    public boolean isAdmin(String name,String password){
        //表单校验
        if(name==null || "".equals(name)){
            throw new UserException(UserEnum.ACCOUNT_NOT_NULL);
        }else if(password==null || "".equals(password)){
            throw new UserException(UserEnum.PASSWORD_NOT_NULL);
        }

        //从数据库取出相关数据进行匹配
        User user=new User();

        user.setName(name);
        user.setPassword(password.toUpperCase());

        var user1=dao.check(user);

        if(!(user1==null)){
            return true;
        }else{
            throw new UserException(UserEnum.NOT_MATCH);
        }


    }
}
