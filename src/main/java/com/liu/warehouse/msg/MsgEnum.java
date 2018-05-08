package com.liu.warehouse.msg;

/**
 * @author 刘仁楠
 * @date 2018/4/27 16:00
 */
public enum MsgEnum implements MsgInterface {
    OPS_SUCCESS(100000, "操作成功"),

    OPS_FAILURE(100001, "操作失败"),;

    private String msg;

    private int code;

    MsgEnum(int _code, String msg) {
        this.code = _code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
