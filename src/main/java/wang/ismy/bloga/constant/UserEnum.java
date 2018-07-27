package wang.ismy.bloga.constant;

public enum UserEnum {

    ACCOUNT_NOT_NULL("账号不能为空"),

    PASSWORD_NOT_NULL("密码不能为空"),

    NOT_MATCH("账号密码不匹配"),

    AUTH_FAILED("认证失败");

    private String msg;
    UserEnum(String str) {
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }
}
