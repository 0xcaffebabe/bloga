package wang.ismy.bloga.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wang.ismy.bloga.entity.ArticleViewer;

public interface ArticleViewerRepository extends JpaRepository<ArticleViewer,Integer> {
}
