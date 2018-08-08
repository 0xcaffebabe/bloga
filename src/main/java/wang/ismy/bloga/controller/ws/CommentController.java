package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.entity.Comment;
import wang.ismy.bloga.service.CommentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/ws/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

//    获取所有评论
    @GetMapping("")
    @Token
    public Object getAllComments(@RequestParam("token") String token){
        return commentService.getComments();
    }

//    更新评论
    @PostMapping("")
    @Token
    public Object modifyComment(@RequestParam("token") String token,
                                @RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

//    删除评论
    @DeleteMapping("/{id}")
    @Token
    public Object deleteComment(@RequestParam("token") String token,
                                @PathVariable("id") Integer id){
        return commentService.deleteComment(id);
    }

}
