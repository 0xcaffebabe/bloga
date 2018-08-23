package wang.ismy.bloga.service;


import net.ipip.datx.IPv4FormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.ismy.bloga.dao.LogDao;
import wang.ismy.bloga.entity.*;
import wang.ismy.bloga.service.ws.IpService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogDao logDao;

    @Autowired
    private ArticleViewerService articleViewerService;

    @Autowired
    private IpService ipService;

    @Autowired
    private RegionService regionService;

//    增加一条日志
    public Log addLog(Log log){
        Log returnLog=logDao.addLog(log);
        if(returnLog.getUrl().startsWith("/article")){
//            如果是以/article开头的话

            //同时记录给文章浏览模块
            ArticleViewer viewer=new ArticleViewer();
            viewer.setLogId(log.getId());
            Integer articleId;
            try{
                articleId=Integer.parseInt(returnLog.getUrl().replace("/article/",""));
                viewer.setArticleId(articleId);
            }catch (Exception e) {
                //如果出现异常，就
                try {
                    articleId = Integer.parseInt(returnLog.getUrl()
                            .replace("/article/", "").substring(0, returnLog.getUrl().indexOf("?")));
                    viewer.setArticleId(articleId);
                } catch (Exception e1) {

                }

            }
            articleViewerService.insert(viewer);

        }

        //记录下相关地区信息
        try {
            Region region=ipService.getRegionByIp(log.getIp());
            regionService.updateRegion(region);
        } catch (IPv4FormatException e) {

        }

        return returnLog;
    }

    public List<Log> getRequestLog(){
        var list= logDao.getRequestLog();

        var ret=new ArrayList<Log>();
        for(var map :list){
            Log log=new Log();
            log.setId((Integer) map.get("id"));
            log.setIp(map.get("ip").toString());
            log.setUrl(map.get("url").toString());
            log.setUa(map.get("ua").toString());
            log.setTime((Date) map.get("time"));
            log.setDelay((Integer)map.get("delay"));
            ret.add(log);
        }
        return ret;
    }

    public List<StayTime> getStayTimeLog(){
        var list= logDao.getStayTimeLog();
        var ret=new ArrayList<StayTime>();
        for(var map :list){
           StayTime stayTime=new StayTime();
            stayTime.setId((Integer) map.get("id"));
            stayTime.setIp(map.get("ip").toString());
            stayTime.setUrl(map.get("url").toString());
            stayTime.setResidenceTime((Integer)map.get("residence_time"));
            stayTime.setTime((Date) map.get("time"));
            ret.add(stayTime);
        }
        return ret;
    }

    public List<Situation> getSituationLog(){
        var list= logDao.getSituationLog();
        var ret=new ArrayList<Situation>();
        for(var map :list){
            Situation situation=new Situation();
            situation.setId((Integer) map.get("id"));
            situation.setMsg(map.get("msg").toString());
            situation.setTime((Date) map.get("time"));
            ret.add(situation);
        }
        return ret;
    }


    public List<SqlLog> getSqlLog(){
        var list= logDao.getSqlLog();
        var ret=new ArrayList<SqlLog>();
        for(var map :list){
            SqlLog log=new SqlLog();
            log.setId((Integer) map.get("id"));
            log.setSentence(map.get("sentence").toString());
            log.setTime((Date) map.get("time"));
            ret.add(log);
        }
        return ret;
    }
}
