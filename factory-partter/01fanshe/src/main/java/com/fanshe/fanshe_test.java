package com.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: factory-partter
 * @description: 反射的实验
 * @author: Mr.huang
 * @create: 2019-05-15 23:11
 **/
public class fanshe_test {
    public static void main(String[] args) throws Exception {
        //反射都会通过构造函数实例化对象的
        //直接实例化
        UserEntiry userEntiry = new UserEntiry();
        userEntiry.setUserName("小红");
        System.out.println(userEntiry);


        //反射1:forname(包路径)
        Class<?> forName = Class.forName("com.fanshe.UserEntiry");
        UserEntiry userEntiry1 = (UserEntiry) forName.newInstance();
        userEntiry1.setUserName("小明");
        System.out.println(userEntiry1);


        //反射2:类.class
        Class<UserEntiry> aClass = UserEntiry.class;
        UserEntiry userEntiry2 = aClass.newInstance();
        userEntiry2.setUserName("小狗");
        System.out.println(userEntiry2);

        //反射3:实例化后的类.getclass()
        UserEntiry a = new UserEntiry();
        Class<? extends UserEntiry> b = a.getClass();
        UserEntiry c = b.newInstance();
        c.setUserName("笑笑");
        System.out.println(c);

        //获取属性
        Field[] fields = forName.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println(field);
        }

        //获取方法
        Method[] methods = forName.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            System.out.println(method);
        }

    }
}
