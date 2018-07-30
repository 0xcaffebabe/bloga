package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.ismy.bloga.dao.LogDao;
import wang.ismy.bloga.entity.ArticleViewer;
import wang.ismy.bloga.entity.Log;

@Service
public class LogService {

    @Autowired
    private LogDao logDao;

    @Autowired
    private ArticleViewerService articleViewerService;

    public Log addLog(Log log){
        Log returnLog=logDao.addLog(log);
        if(returnLog.getUrl().startsWith("/article")){
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
        return returnLog;
    }
}
