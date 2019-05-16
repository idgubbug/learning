package com.adapter;

/**
 * @Description: 2号接口的实现类
 * @Param: * @param null
 * @return:
 * @Author: Mr.huang
 * @Date: 2019/5/16 14:26
 **/
public class CN220VInterfaceImpl implements CN220VInterface {

    @Override
    public void connect() {
        System.out.println("中国220V,接通电源,开始工作");

    }

}