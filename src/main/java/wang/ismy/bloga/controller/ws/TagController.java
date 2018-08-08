package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.entity.Tag;
import wang.ismy.bloga.service.TagService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ws/tag")
public class TagController {

    @Autowired
    private TagService tagService;

//    获取所有标签
    @GetMapping("")
    @Token
    public Object getAllTags(@RequestParam("token") String token){
        return tagService.getAll();
    }

//    新增标签
    @PutMapping("")
    @Token
    public Object addTag(@RequestParam("token") String token,
                         @RequestBody @Valid Tag tag){
        return tagService.addTag(tag);
    }

//    根据ID删除标签
    @DeleteMapping("/{id}")
    @Token
    public Object deleteTag(@RequestParam("token") String token,
                         @PathVariable("id") Integer id){
        return tagService.deleteTag(id);
    }

//    根据ID列表批量删除标签
    @DeleteMapping("")
    @Token
    public Object deleteTagBatch(@RequestParam("token") String token,
                            @RequestBody List<Integer> idLis){
        return tagService.deleteTagBatch(idLis);
    }

//    搜索标签
    @GetMapping("/search/{keyWord}")
    @Token
    public Object searchTag(@RequestParam("token") String token,
                            @PathVariable("keyWord") String keyWord){
        return tagService.searchTag(keyWord);
    }
}
