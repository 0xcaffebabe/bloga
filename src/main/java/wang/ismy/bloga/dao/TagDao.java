package wang.ismy.bloga.dao;

import wang.ismy.bloga.entity.Tag;

import java.util.List;

public interface TagDao {
    //获取全部标签
    List<Tag> getTags();
    //根据文章ID获取标签
    List<Tag> getTagsByArticleId(int id);
    //删除标签
    int deleteTag(int id);
    //更新标签
    int updateTag(Tag tag);
    //新增标签
    int addTag(Tag tag);
}
