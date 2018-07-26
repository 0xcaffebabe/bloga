package wang.ismy.bloga.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.ismy.bloga.dao.inter.ITag;
import wang.ismy.bloga.dao.repository.TagRepository;
import wang.ismy.bloga.entity.Tag;

import java.util.List;

@Component
public class TagDao {

    @Autowired
    private TagRepository repository;

    @Autowired
    private ITag iTag;

    //获取全部标签
    public List<Tag> getTags(){
        return repository.findAll();
    }
    //根据文章ID获取标签
    public String getTagsByArticleId(int id){
        return null;
    }
    //删除标签
    public int deleteTag(int id){
        return iTag.deleteTag(id);
    }
    //更新标签
    public int updateTag(Tag tag){
        return iTag.updateTag(tag);
    }
    //新增标签
    public Tag addTag(Tag tag){
       return repository.save(tag);
    }
}
