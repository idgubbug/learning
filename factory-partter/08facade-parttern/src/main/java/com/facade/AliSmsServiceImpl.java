
package com.facade;

/**
 * @Description: 短信接口实现类
 * @Param: * @param null
 * @return:
 * @Author: Mr.huang
 * @Date: 2019/5/16 14:45
 **/
public class AliSmsServiceImpl implements AliSmsService {

    @Override
    public void sendSms() {
        System.out.println("支付宝发送消息...");
    }

}
