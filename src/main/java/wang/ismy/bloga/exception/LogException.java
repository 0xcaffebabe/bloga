package wang.ismy.bloga.exception;

import wang.ismy.bloga.constant.LogEnum;

public class LogException extends RuntimeException {

    public LogException(LogEnum logEnum){
        super(logEnum.getMsg());
    }

}
