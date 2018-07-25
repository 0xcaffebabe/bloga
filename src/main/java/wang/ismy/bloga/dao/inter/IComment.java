package wang.ismy.bloga.dao.inter;


import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.Comment;

@Mapper
public interface IComment {

    int deleteComment(int id);

    int updateComment(Comment comment);
}
