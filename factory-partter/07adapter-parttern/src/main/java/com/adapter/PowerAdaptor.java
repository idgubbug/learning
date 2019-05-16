package com.adapter;

/**
 * @Description:
 * @Param: * @param null
 * @return:
 * @Author: Mr.huang
 * @Date: 2019/5/16 14:28
 **/
public class PowerAdaptor implements JP110VInterface {
    private CN220VInterface cn220VInterface;

    public PowerAdaptor(CN220VInterface cn220VInterface) {
        this.cn220VInterface = cn220VInterface;
    }

    @Override
    public void connect() {
        cn220VInterface.connect();
    }

}