package wang.ismy.bloga.constant;

public enum LogEnum {
    DATE_NULL(1,"日期为空!");
    private int code;
    private String msg;


    private LogEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
