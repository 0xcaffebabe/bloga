package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.entity.Tag;
import wang.ismy.bloga.service.TagService;

import javax.validation.Valid;

@RestController
@RequestMapping("/ws/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("")
    @Token
    public Object getAllTags(@RequestParam("token") String token){
        return tagService.getAll();
    }

    @PutMapping("")
    @Token
    public Object addTag(@RequestParam("token") String token,
                         @RequestBody @Valid Tag tag){
        return tagService.addTag(tag);
    }

    @DeleteMapping("/{id}")
    @Token
    public Object deleteTag(@RequestParam("token") String token,
                         @PathVariable("id") Integer id){
        return tagService.deleteTag(id);
    }
}
