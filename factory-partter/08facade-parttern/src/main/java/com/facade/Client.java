package com.facade;

public class Client {
    /**
     * @Description: 外观模式: 隐藏系统的复杂性，
     * 并向客户端提供了一个客户端可以访问系统的接口
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/16 14:47
     **/
    public static void main(String[] args) {
        //直接调动
        // AliSmsService aliSmsService= new AliSmsServiceImpl();
        // EamilSmsService eamilSmsService= new EamilSmsServiceImpl();
        // WeiXinSmsService weiXinSmsService= new WeiXinSmsServiceImpl();
        // aliSmsService.sendSms();
        // eamilSmsService.sendSms();
        // weiXinSmsService.sendSms();
        //调用外观模式的(门面模式)
        new Computer().sendMsg();
    }

}
