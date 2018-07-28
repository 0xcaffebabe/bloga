package wang.ismy.bloga.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class CacheService {

    private static Jedis jedis;
    static{
        jedis=new Jedis("127.0.0.1",6379);
    }

    public CacheService set(String key,String value){
        jedis.set(key,value);
        return this;
    }

    public String get(String key){
        return jedis.get(key);
    }
}
