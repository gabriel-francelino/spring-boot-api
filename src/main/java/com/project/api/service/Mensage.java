package com.project.api.service;

import org.springframework.stereotype.Component;

@Component // é usado para criar um objeto gerenciado pelo Spring que pode ser reutilizado em toda a aplicação.
public class Mensage {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
