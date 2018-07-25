package wang.ismy.bloga.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ismy.bloga.entity.User;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

//    @Autowired
//    private UserDao dao;

    @Autowired
    private TestRepository repository;
    @Test
    public void getUsers() {
        User user=new User();
        user.setName("admin");
        user.setPassword("715711");
        repository.save(user);
    }

}