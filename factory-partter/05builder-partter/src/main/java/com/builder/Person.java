package com.builder;

/**
 * @program: factory-partter
 * @description: 实体类
 * @author: Mr.huang
 * @create: 2019-05-16 13:55
 **/

public class Person {
    public String head;
    public String body;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
