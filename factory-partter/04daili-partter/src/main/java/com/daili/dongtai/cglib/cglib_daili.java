package com.daili.dongtai.cglib;

import com.daili.static_.UserDaoImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: factory-partter
 * @description: cglib动态代理模式
 * @author: Mr.huang
 * @create: 2019-05-16 00:16
 **/
public class cglib_daili implements MethodInterceptor {
    private Object targetObject;

    public Object getInstance(Object target) {
        this.targetObject = target;
        // 操作字节码 生成虚拟子类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事物");
        Object invoke = methodProxy.invoke(targetObject, objects);
        System.out.println("提交事物");
        return invoke;
    }

    public static void main(String[] args) {
        cglib_daili cglibProxy = new cglib_daili();
        UserDaoImpl userDaoImpl = (UserDaoImpl) cglibProxy.getInstance(new UserDaoImpl());
        userDaoImpl.save();
        // 怎么判断一个类是否实现接口？

    }
}
