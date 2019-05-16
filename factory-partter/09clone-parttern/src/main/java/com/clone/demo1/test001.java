package com.clone.demo1;

/**
 * @program: factory-partter
 * @description: 测试, 直接调用, 不用clone, 单例
 * @author: Mr.huang
 * @create: 2019-05-16 15:04
 **/
public class test001 {
    /**
     * @Description: 直接调用, 没有只用原型模式, 当使用的同一个实例存在的数量太多的时候, 可以使用原型模式clone出同一个对象
     * 节省创建的资源
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/16 15:09
     **/
    public static void main(String[] args) {
        Book book = new Book();
        book.setAge(10);
        book.addImg("天上");
        book.setTitle("好");
        book.showBook();
    }
}
