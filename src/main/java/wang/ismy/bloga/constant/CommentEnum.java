package wang.ismy.bloga.constant;

public enum CommentEnum {

    ID_NOT_NULL("ID不能为空");

    private String msg;
    CommentEnum(String msg) {
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }
}
