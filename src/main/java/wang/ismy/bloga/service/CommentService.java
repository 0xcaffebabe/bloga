package wang.ismy.bloga.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.constant.CommentEnum;
import wang.ismy.bloga.dao.CommentDao;
import wang.ismy.bloga.entity.Comment;
import wang.ismy.bloga.exception.CommentExpection;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    //增加一条评论
    public Comment addComment(Comment comment){
        if(comment==null){
            throw new NullPointerException();
        }
        if(comment.getParentId()==null){
            comment.setParentId(0);
        }
        comment.setTime(new Date());
        comment.setVisible(1);
        return commentDao.addComment(comment);
    }

    //获取所有评论
    public List<Comment> getComments(){
        return commentDao.getComments();
    }

    //更新评论
    public int updateComment(Comment comment){
        if(comment==null){
            throw new NullPointerException();
        }

        if(comment.getId()==null){
            throw new CommentExpection(CommentEnum.ID_NOT_NULL);
        }

        return commentDao.updateComment(comment);
    }

    //删除评论
    public int deleteComment(Integer id){
        if(id==null){
            throw new CommentExpection(CommentEnum.ID_NOT_NULL);
        }

        return commentDao.deleteComment(id);
    }

    public List<Comment> getCommentListByArticleId(Integer articleId){
        return commentDao.getCommentListByArticleId(articleId);
    }
}
