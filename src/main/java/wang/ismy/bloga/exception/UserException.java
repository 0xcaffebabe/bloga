package wang.ismy.bloga.exception;

import wang.ismy.bloga.constant.UserEnum;

public class UserException extends RuntimeException {


    public UserException(UserEnum userEnum) {
        super(userEnum.getMsg());
    }
}
