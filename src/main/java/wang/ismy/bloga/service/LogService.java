package wang.ismy.bloga.service;


import net.ipip.datx.IPv4FormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.ismy.bloga.dao.LogDao;
import wang.ismy.bloga.entity.ArticleViewer;
import wang.ismy.bloga.entity.Log;
import wang.ismy.bloga.entity.Region;
import wang.ismy.bloga.service.ws.IpService;

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
}
