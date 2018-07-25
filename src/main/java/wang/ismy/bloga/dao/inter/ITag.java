package wang.ismy.bloga.dao.inter;

import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.Tag;

@Mapper
public interface ITag {

    int deleteTag(int id);

    int updateTag(Tag tag);

}
