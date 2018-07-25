package wang.ismy.bloga.constant;

public enum SettingEnum {
    DEFAULT_SINGLE_PAGE_NUMBER(10); //默认单页元素数量

    private int code;
    SettingEnum(int i) {
        code=i;
    }

    public int getCode() {
        return code;
    }
}
