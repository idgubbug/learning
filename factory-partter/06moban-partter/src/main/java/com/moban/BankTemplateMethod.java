package com.moban;

/**
 * @program: factory-partter
 * @description: 模板方法, 写入公共代码, 重复利用的功能
 * @author: Mr.huang
 * @create: 2019-05-16 14:15
 **/

/** 
* @Description: 模板方法, 在父类中写入重复代码,在子类实现类中写入业务代码
* @Param:  * @param null 
* @return:  
* @Author: Mr.huang
* @Date: 2019/5/16 14:16 
**/ 
public abstract class BankTemplateMethod {
    // 1.取号排队
    public void takeNumber() {
        System.out.println("取号排队。。");
    }

    // 2.每个子类不同的业务实现，由各自子类实现.
    abstract void transact();

    // 3.评价
    public void evaluate() {
        System.out.println("反馈评价..");
    }

    public void process() {
        takeNumber();
        transact();
        evaluate();
    }
}
