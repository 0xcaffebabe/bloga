package wang.ismy.bloga.service.ws;

import net.ipip.datx.IPv4FormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IpServiceTest {

    @Autowired
    private IpService ipService;
    @Test
    public void getCityByIp() throws IPv4FormatException {

    }
}