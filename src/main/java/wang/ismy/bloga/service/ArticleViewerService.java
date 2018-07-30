package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.inter.IArticleViewer;
import wang.ismy.bloga.dao.repository.ArticleViewerRepository;
import wang.ismy.bloga.entity.ArticleViewer;

@Service
public class ArticleViewerService {

    @Autowired
    private ArticleViewerRepository viewerRepository;

    @Autowired
    private IArticleViewer iArticleViewer;

    public ArticleViewer insert(ArticleViewer viewer){
        return viewerRepository.save(viewer);
    }
}
