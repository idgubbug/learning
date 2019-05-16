package com.daili.static_;

/**
 * @program: factory-partter
 * @description: 静态代理模式, 代码写死
 * @author: Mr.huang
 * @create: 2019-05-15 23:56
 **/
public class static_daili {
    private UserDao userDao;

    public static_daili(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("开启事物...");
        userDao.save();
        System.out.println("关闭事物...");
    }

    /**
     * @Description: 静态代理模式: 代理类和委托类的关系在运行前就确定了
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/16 0:00
     **/
    public static void main(String[] args) {
        static_daili daili = new static_daili(new UserDaoImpl());
        daili.save();
    }
}




