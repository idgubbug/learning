package com.factory;

public interface Car {
    public void run();
}

class Client01 {
    /**
     * @Description: 工厂模式可以降低程序的耦合性
     * 方便统一管理对象
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15 23:47
     **/
    public static void main(String[] args) {
        Car aodi = CarFactory.createCar("奥迪");
        Car jili = CarFactory.createCar("吉利");
        aodi.run();
        jili.run();
    }

}