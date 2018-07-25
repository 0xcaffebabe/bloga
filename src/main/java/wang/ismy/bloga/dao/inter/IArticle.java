package wang.ismy.bloga.dao.inter;

import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.Article;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Map;

@Mapper
public interface IArticle {
    int deleteArticle(int id);

    int updateArticle(Article article);

    List<Article> getArticlesByPage(Map<String,Object> map);
}
