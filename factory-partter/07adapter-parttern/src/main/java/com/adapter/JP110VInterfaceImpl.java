package com.adapter;

/**
 * @Description: 实现类
 * @Param: * @param null
 * @return:
 * @Author: Mr.huang
 * @Date: 2019/5/16 14:24
 **/
public class JP110VInterfaceImpl implements JP110VInterface {

    @Override
    public void connect() {
        System.out.println("日本110V,接通电源,开始工作..");
    }

}