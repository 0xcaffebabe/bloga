package wang.ismy.bloga.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.ismy.bloga.dao.inter.IUser;
import wang.ismy.bloga.dao.repository.UserRepository;
import wang.ismy.bloga.entity.User;

import java.util.List;

@Component
public class UserDao {


    @Autowired
    private UserRepository repository;

    @Autowired
    private IUser iUser;

    //获取全部用户
    public List<User> getUsers(){
        return repository.findAll();
    }
    //检查user账号的密码是否匹配
    public User check(User user){
        return iUser.check(user);
    }

    public User getUserByName(String name) {
        return iUser.getUserByName(name);
    }
}
