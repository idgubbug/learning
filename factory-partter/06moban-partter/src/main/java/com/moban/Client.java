package com.moban;

/**
 * @program: factory-partter
 * @description: 测试类
 * @author: Mr.huang
 * @create: 2019-05-16 14:18
 **/
public class Client {
    /**
     * @Description: 实现一些操作时，整体步骤很固定，但是呢。
     * 就是其中一小部分容易变，这时候可以使用模板方法模式，
     * 将容易变的部分抽象出来，供子类实现。
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/16 14:20
     **/
    public static void main(String[] args) {
        BankTemplateMethod bankTemplate = new DrawMoney();
        bankTemplate.process();

        System.out.println("==================");

        BankTemplateMethod bankTemplateMethod = new BankTemplateMethod() {
            @Override
            void transact() {
                System.out.println("我要存钱.");
            }
        };
        bankTemplateMethod.process();
    }
}
