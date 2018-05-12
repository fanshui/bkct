package com.bkct.model.response;

public class Response<T> {

    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Meta meta;
    private T data;

    public Response success() {
        this.meta = new Meta(true, OK);
        return this;
    }

    public Response success(T data) {
        this.meta = new Meta(true, OK);
        this.data = data;
        return this;
    }

    public Response failure() {
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public Response failure(String message) {
        this.meta = new Meta(false, message);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public T getData() {
        return data;
    }

}
