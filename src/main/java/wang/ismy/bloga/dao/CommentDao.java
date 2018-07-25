package wang.ismy.bloga.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.ismy.bloga.dao.inter.IComment;
import wang.ismy.bloga.dao.repository.CommentRepository;
import wang.ismy.bloga.entity.Comment;

import java.util.List;


@Component
public class CommentDao {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private IComment iComment;

    //获取全部评论
    List<Comment> getComments(){
       return repository.findAll();
    }
    //根据文章ID获取评论
    Comment getCommentByArticleId(int id){
        return repository.getOne(id);
    }
    //删除评论
    int deleteComment(int id){
        return iComment.deleteComment(id);
    }
    //修改评论
    int updateComment(Comment comment){
        return iComment.updateComment(comment);
    }
    //新增评论
    Comment addComment(Comment comment){
        return repository.save(comment);
    }
}
