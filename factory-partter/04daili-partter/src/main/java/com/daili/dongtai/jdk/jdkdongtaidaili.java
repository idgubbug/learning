package com.daili.dongtai.jdk;

import com.daili.static_.UserDao;
import com.daili.static_.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: factory-partter
 * @description: jdk动态代理模式
 * @author: Mr.huang
 * @create: 2019-05-16 00:05
 **/
public class jdkdongtaidaili implements InvocationHandler {
    private Object target;// 这其实业务实现类对象，用来调用具体的业务方法

    // 通过构造函数传入目标对象
    public jdkdongtaidaili(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("调用开始处理");
        result = method.invoke(target, args);
        System.out.println("调用结束处理");
        return result;
    }

    /**
     * @Description: jdk动态代理模式, 是面向接口编程的模式, 需要类事项InvocationHandler,
     * 重写invoke()方法,将目标接口传入,接着获取类加载器,当前实现的接口,动用带胎代理实例
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/16 0:14
     **/
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        jdkdongtaidaili jdkdongtaidaili = new jdkdongtaidaili(userDao);
        //获取类加载器
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        //获取当前实现的接口
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        //调用动态代理实例
        UserDao dest = (UserDao) Proxy.newProxyInstance(classLoader, interfaces, jdkdongtaidaili);

        dest.save();
    }
}
