package wang.ismy.bloga.dao.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wang.ismy.bloga.entity.Article;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {
}
