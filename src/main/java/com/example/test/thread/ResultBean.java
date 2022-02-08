package com.example.test.thread;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class ResultBean<T> implements Serializable {

    private static final long SLONG = 1L;

    /**
     * 成功状态
     */
    public static final int SUCCESS = 1;

    /**
     * 处理中状态
     */
    public static final int PROCESSING = 0;

    /**
     * 失败状态
     */
    public static final int FALL = -1;

    /**
     * 描述
     */
    private String msg = "success";

    /**
     * 状态默认成功
     */
    private int code = SUCCESS;

    /**
     * 备注
     */
    private String remark;

    /**
     * 返回数据
     */
    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    /**
     * 使用异常创建结果
     */
    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FALL;
    }

    public static <T> ResultBean<T> newInstance() {
        ResultBean<T> instance = new ResultBean<T>();
        //默认返回信息
        instance.code = SUCCESS;
        instance.msg = "success";
        return instance;
    }

    public static <T> ResultBean<T> newInstance(T data) {
        ResultBean<T> instance = new ResultBean<T>();
        //默认返回信息
        instance.code = SUCCESS;
        instance.msg = "success";
        instance.data = data;
        return instance;
    }

    public static <T> ResultBean<T> newInstance(int code, String msg) {
        ResultBean<T> instance = new ResultBean<T>();
        //默认返回信息
        instance.code = code;
        instance.msg = msg;
        return instance;
    }

    public static <T> ResultBean<T> newInstance(int code, String msg, T data) {
        ResultBean<T> instance = new ResultBean<T>();
        //默认返回信息
        instance.code = code;
        instance.msg = msg;
        instance.data = data;
        return instance;
    }

    public String getMsg() {
        return msg;
    }

    public ResultBean<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResultBean<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ResultBean<T> setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultBean<T> setData(T data) {
        this.data = data;
        return this;
    }

    public ResultBean<T> success(String msg) {
        this.code = SUCCESS;
        this.msg = msg;
        return this;
    }

    public ResultBean<T> success(String msg, T data) {
        this.code = SUCCESS;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public ResultBean<T> processing(String msg) {
        this.code = PROCESSING;
        this.msg = msg;
        return this;
    }

    public ResultBean<T> processing(String msg, T data) {
        this.code = PROCESSING;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public ResultBean<T> fail(String msg) {
        this.code = FALL;
        this.msg = msg;
        return this;
    }

    public ResultBean<T> fail(String msg, T data) {
        this.code = FALL;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public String json() {
        return JSON.toJSONString(this);
    }
}
