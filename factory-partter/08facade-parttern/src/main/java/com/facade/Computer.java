package com.facade;

/**
 * @Description: 外观模式的设计, 将3个功能写入包装起来.类似封装特性
 * @Param: * @param null
 * @return:
 * @Author: Mr.huang
 * @Date: 2019/5/16 14:46
 **/
//门面类
public class Computer {
    AliSmsService aliSmsService;
    EamilSmsService eamilSmsService;
    WeiXinSmsService weiXinSmsService;

    public Computer() {
        aliSmsService = new AliSmsServiceImpl();
        eamilSmsService = new EamilSmsServiceImpl();
        weiXinSmsService = new WeiXinSmsServiceImpl();
    }

    public void sendMsg() {
        aliSmsService.sendSms();
        eamilSmsService.sendSms();
        weiXinSmsService.sendSms();

    }

}
