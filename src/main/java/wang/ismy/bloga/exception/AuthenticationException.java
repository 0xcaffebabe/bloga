package wang.ismy.bloga.exception;

import wang.ismy.bloga.constant.UserEnum;

public class AuthenticationException extends RuntimeException {



    public AuthenticationException(UserEnum userEnum) {
        super(userEnum.getMsg());
    }
}
