package wang.ismy.bloga.dao.inter;

import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.Article;

import javax.validation.constraints.Max;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface IArticle {
    int deleteArticle(int id);

    int updateArticle(Article article);

    List<Article> getArticlesByPage(Map<String,Object> map);

    List<Article> getRelevantArticles(Map<String,Object> map);

    List<Article> getRecommendArticles(int length);

    List<String> getFile();

    Article getArticlesById(int id);

    int getArticlesNumberByTag(String tag);

    List<Article> getArticlesByTag(Map<String,Object> map);

    int getArticlesNumberByFile(String file);

    List<Article> getArticlesByFile(Map<String,Object> map);

    int getArticlesNumberBySearch(String keyWord);

    List<Article> getArticlesBySearch(HashMap<String,Object> map);

    int deleteArticleBatch(List<Integer> idList);
}
