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


    @Autowired
    UserDao dao;

    @Test
    public void getUsers() {
        assertEquals(1,dao.getUsers().size());
    }

    @Test
    public void check() {
        User user=new User();

        user.setName("admin");

        user.setPassword("dsds");

        System.out.println(dao.check(user));
    }

}