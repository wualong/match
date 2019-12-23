package org.spring.match.dto;

import java.io.Serializable;

public class RData<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private T data;

    private String msg;

    public RData() {
    }

    private RData(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> RData<T> okData(T data) {
        return okData(data, "操作成功");
    }

    public static <T> RData<T> okData(T data, String msg) {
        return okData(200, data, msg);
    }

    public static <T> RData<T> okData(int code, T data, String msg) {
        return new RData(code, data, data == null ? "暂无承载数据" : msg);
    }

    public static <T> RData<T> fail(T data) {
        return fail(data, "操作失败");
    }

    public static <T> RData<T> fail(T data, String msg) {
        return fail(400, data, msg);
    }

    public static <T> RData<T> fail(int code, T data, String msg) {
        return new RData(code, data, data == null ? "暂无承载数据" : msg);
    }

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "R(code=" + this.getCode() + ", success="  + ", data=" + this.getData() + ", msg=" + this.getMsg() + ")";
    }
}
