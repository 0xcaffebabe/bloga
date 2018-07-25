package wang.ismy.bloga;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ismy.bloga.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogaApplicationTests {

    @Autowired
    private UserDao dao;
    @Test
    public void contextLoads() {
        System.out.println(dao.getUsers());
    }

}
