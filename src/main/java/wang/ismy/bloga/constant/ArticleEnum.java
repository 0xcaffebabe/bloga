package wang.ismy.bloga.constant;

public enum ArticleEnum {

    PAGE_NUMBER_OUT_BOUND("页数下标炸了"),

    ARTICLE_NOT_EXIST("文章不存在"),

    ARTICLE_TAG_NOT_NULL("文章标签不能为空");

    private String msg;
    ArticleEnum(String msg) {
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }
}
