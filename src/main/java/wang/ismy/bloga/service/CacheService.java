package wang.ismy.bloga.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    public static Map<String,Object> cachePool=new HashMap<>();

    public static Map<String,Integer> ttl=new HashMap<>();

    public static Map<String,Integer> tmp=new HashMap<>();

//    加入缓存
    public synchronized CacheService set(String key,Object value,int expire){
        cachePool.put(key,value);
        ttl.put(key,expire);
        tmp.put(key,expire);
        return this;
    }

//    获取缓存
    public Object get(String key){
        if(isExist(key)){
            synchronized (ttl){
                ttl.put(key,tmp.get(key));
            }
            return cachePool.get(key);
        }
        return null;
    }

//    指定缓存是否存在
    public boolean isExist(String key){
        return cachePool.containsKey(key);
    }

//    定时清理缓存任务
    @Scheduled(cron = "0/1 * * * * ? ")
    public synchronized void clean(){
        ArrayList<String> keys=new ArrayList<>();
        for(var i:ttl.keySet()){
            if(ttl.get(i)<0){
                keys.add(i);
            }else{
                ttl.put(i,ttl.get(i)-1);
            }
        }
        for(var i:keys){
            cachePool.remove(i);
            ttl.remove(i);
            tmp.remove(i);
        }
    }
}
