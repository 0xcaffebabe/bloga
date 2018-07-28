package wang.ismy.bloga.exception;

import wang.ismy.bloga.constant.CommentEnum;

public class CommentExpection extends RuntimeException {

    public CommentExpection(CommentEnum commentEnum) {
        super(commentEnum.getMsg());
    }
}
