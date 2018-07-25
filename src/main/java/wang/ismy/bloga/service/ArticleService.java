package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.ArticleDao;
import wang.ismy.bloga.dao.SettingDao;
import wang.ismy.bloga.entity.Article;
import wang.ismy.bloga.entity.Setting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Autowired
    private SettingService settingService;

    public List<Article> getArticles(Integer pageNumber){
        if(pageNumber==null){
            pageNumber=1;
        }
        //设置分页相关参数
        var map=new HashMap<String,Object>();
        int single=settingService.getSinglePageNumber();
        map.put("offset",(pageNumber-1)*single);
        map.put("length",single);
        var ret=articleDao.getArticlesByPage(map);
        //对tags进行分割，并将其存储到tagSet
        for(var i:ret){
            i.setTagSet(Set.of(i.getTags().split(",")));
        }
        return ret;
    }


}
