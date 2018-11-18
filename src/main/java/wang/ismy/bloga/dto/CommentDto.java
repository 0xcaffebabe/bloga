package wang.ismy.bloga.dto;


import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class CommentDto {

    private Integer articleId;

    private String nickName;

    @Email(message = "请输入有效的有效")
    private String email;

    private String content;

}
