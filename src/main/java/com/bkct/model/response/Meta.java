package com.bkct.model.response;

public class Meta {
    private boolean sucess;
    private String message;

    public Meta(boolean sucess) {
        this.sucess = sucess;
    }

    public Meta(boolean sucess,String message) {
        this.sucess = sucess;
        this.message = message;
    }

    public boolean isSucess() {
        return sucess;
    }

    public String getMessage() {
        return message;
    }

}
