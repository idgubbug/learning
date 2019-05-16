package com.singleton;

/**
 * @program: factory-partter
 * @description: 饿汉模式
 * @author: Mr.huang
 * @create: 2019-05-15 23:24
 **/
public class SingletonDemo01 {
    private static SingletonDemo01 singletonDemo01 = new SingletonDemo01();

    public SingletonDemo01() {
        System.out.println("singletondemo01初始化");
    }

    public static SingletonDemo01 getInstance() {
        System.out.println("getInstance");
        return singletonDemo01;
    }

    /**
     * @Description: 饿汉模式, 迫不及待的使用实例,先生产等待别使用
     *
     * 单例模式:保证一个类只有一个实例，并且提供一个访问该全局访问点
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15 23:27
     **/
    public static void main(String[] args) {
        SingletonDemo01 s1 = SingletonDemo01.getInstance();
        SingletonDemo01 s2 = SingletonDemo01.getInstance();
        System.out.println(s1 == s2);
    }

}
