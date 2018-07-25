package wang.ismy.bloga.dao;

import wang.ismy.bloga.entity.Comment;

import java.util.List;

public interface CommentDao {
    //获取全部评论
    List<Comment> getComments();
    //根据文章ID获取评论
    Comment getCommentByArticleId(int id);
    //删除评论
    int deleteComment(int id);
    //修改评论
    int updateComment(Comment comment);
    //新增评论
    int addComment(Comment comment);
}
