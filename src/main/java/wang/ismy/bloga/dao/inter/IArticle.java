package wang.ismy.bloga.dao.inter;

import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.Article;

@Mapper
public interface IArticle {
    int deleteArticle(int id);

    int updateArticle(Article article);
}
