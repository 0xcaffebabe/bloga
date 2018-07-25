package wang.ismy.bloga.dao;

import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.User;

import java.util.List;

@Mapper
public interface UserDao {
    //获取全部用户
    List<User> getUsers();
    //检查user账号的密码是否匹配
    User check(User user);
}
