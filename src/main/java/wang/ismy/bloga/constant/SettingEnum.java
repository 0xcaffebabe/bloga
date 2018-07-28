package wang.ismy.bloga.constant;

public enum SettingEnum {
    DEFAULT_SINGLE_PAGE_NUMBER(10), //默认单页元素数量
    DEFAULT_EDGE_ARTICLE_NUMBER(6), //默认边缘展示文章数

    ID_NOT_NULL("ID不准为空");
    private int code;

    private String msg;
    SettingEnum(int i) {
        code=i;
    }

    SettingEnum(String msg) {
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
