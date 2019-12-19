package com.example.myapplication.robot;

import java.util.Date;

public class ChatMessage {
    private String name;// 姓名
    private String message;// 訊息
    private Type type;// 型別：0.傳送者 1.接受者
    private Date data;// 時間

    public ChatMessage() {

    }

    public ChatMessage(String message, Type type, Date data) {
        super();
        this.message = message;
        this.type = type;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public enum Type {
        INCOUNT, OUTCOUNT
    }
}
