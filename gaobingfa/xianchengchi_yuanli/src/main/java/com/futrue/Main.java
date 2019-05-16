package com.futrue;

public class Main {
    /**
     * @Description: 首先返回Client一个FutureSubject, 以满足客户端的需求，于此同时呢，Future会通过另外一个Thread
     * 去构造一个真正的资源，资源准备完毕之后，在给future一个通知。如果客户端急于获取这个真正的资源，
     * 那么就会阻塞客户端的其他所有线程，等待资源准备完毕。
     * 类似于异步请求,ajax
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) {
        FutureClient futureClient = new FutureClient();
        Data request = futureClient.request("请求参数.");
        System.out.println("请求发送成功!");
        System.out.println("执行其他任务...");
        String result = request.getRequest();
        System.out.println("获取到结果..." + result);
    }

}