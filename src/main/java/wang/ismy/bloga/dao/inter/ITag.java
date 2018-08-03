package wang.ismy.bloga.dao.inter;

import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.Tag;

import java.util.List;

@Mapper
public interface ITag {

    int deleteTag(int id);

    int updateTag(Tag tag);

    List<Tag> getAll();

    List<Tag> searchTag(String keyWord);

    int deleteTagBatch(List<Integer> idLis);
}
