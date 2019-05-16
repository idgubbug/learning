package com.fanshe;

/**
 * @program: factory-partter
 * @description: 实体类
 * @author: Mr.huang
 * @create: 2019-05-15 23:10
 **/
public class UserEntiry {
    private String userName;

    public UserEntiry(String userName) {
        System.out.println("初始化成功...");
        this.userName = userName;
    }

    public UserEntiry() {
    }

    @Override
    public String toString() {
        return "UserEntiry{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
