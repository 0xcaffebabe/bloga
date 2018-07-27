package wang.ismy.bloga.dao.inter;

import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.User;

@Mapper
public interface IUser {

    User check(User user);

    User getUserByName(String name);
}
