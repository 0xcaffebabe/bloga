package wang.ismy.bloga.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ismy.bloga.entity.Log;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogDaoTest {

    @Autowired
    private LogDao dao;
    @Test
    @Ignore
    public void getLogs() {
        List<Log> logs =dao.getLogs();
        assertEquals(1,logs.size());
    }

    @Test
    public void addLog() {
        Log log=new Log();
        log.setIp("60.205.205.65");
        log.setTime(new Date());
        assertEquals("60.205.205.65",dao.addLog(log).getIp());
    }
}