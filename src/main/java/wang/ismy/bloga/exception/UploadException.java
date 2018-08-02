package wang.ismy.bloga.exception;

import wang.ismy.bloga.constant.UploadEnum;

public class UploadException extends RuntimeException {

    public UploadException(UploadEnum uploadEnum) {
        super(uploadEnum.getMsg());
    }
}
