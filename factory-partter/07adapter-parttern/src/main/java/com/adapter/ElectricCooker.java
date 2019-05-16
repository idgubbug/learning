package com.adapter;

/**
 * @Description: 电饭煲110v的电源接口适配成我们220V的电源接口，
 * 这就需要一个电源适配器
 * @Param: * @param null
 * @return:
 * @Author: Mr.huang
 * @Date: 2019/5/16 14:27
 **/
public class ElectricCooker {

    private JP110VInterface jp110VInterface;//日本电饭煲

    ElectricCooker(JP110VInterface jp110VInterface) {
        this.jp110VInterface = jp110VInterface;
    }

    public void cook() {
        jp110VInterface.connect();
        System.out.println("开始做饭了..");
    }

}