package wang.ismy.bloga.service.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationServiceTest {

    @Autowired
    private AuthenticationService authenticationService;
    @Test
    public void auth() {

    }

    public static void main(String[] args) {
        String user="admin";
        String password=DigestUtils.md5DigestAsHex("123456".getBytes()).toUpperCase();
        String salt="8848";
        String sign=DigestUtils.md5DigestAsHex(((user+password+salt).toUpperCase()).getBytes());
        System.out.println(sign);
    }

}