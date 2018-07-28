package wang.ismy.bloga.exception;

import wang.ismy.bloga.constant.SettingEnum;

public class SettingException extends RuntimeException {

    public SettingException(SettingEnum settingEnum) {
        super(settingEnum.getMsg());
    }
}
