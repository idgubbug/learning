package com.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: gaobingfa
 * @description: 队列模拟生产者和消费者
 * @author: Mr.huang
 * @create: 2019-05-15 21:15
 **/
class produceThread implements Runnable {
    //队列
    private BlockingQueue<String> blockingQueue;
    //原子类
    private AtomicInteger count = new AtomicInteger();
    //判断
    private volatile boolean flag = true;

    public produceThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "生产者开始启动....");
        while (flag) {
            //获取data.一次产生一个
            String data = count.incrementAndGet() + "";
            try {
                //放入队列中 .offer 不能超过2秒钟
                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println(Thread.currentThread().getName() + ",生产队列" + data + "成功..");
                } else {
                    System.out.println(Thread.currentThread().getName() + ",生产队列" + data + "失败..");
                }
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
        System.out.println(Thread.currentThread().getName() + ",生产者线程停止...");
    }

    public void stop() {
        this.flag = false;
    }
}

class consumerThread implements Runnable {
    private volatile boolean flag = true;
    private BlockingQueue<String> blockingQueue;

    public consumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "消费者开始启动....");
        while (flag) {
            try {
                //取出数据,不能超过2秒钟
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (data == null || data == "") {
                    flag = false;
                    System.out.println("消费者超过2秒时间未获取到消息.");
                    return;
                }
                System.out.println("消费者获取到队列信息成功,data:" + data);

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}


public class Blockingqueue_Test {
    public static void main(String[] args) {
        //队列
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(3);
        //生产者
        produceThread producerThread = new produceThread(blockingQueue);
        //消费者
        consumerThread consumerThread = new consumerThread(blockingQueue);
        //启动线程
        Thread t1 = new Thread(producerThread);
        Thread t2 = new Thread(consumerThread);
        t1.start();
        t2.start();
        //10秒后 停止线程..
        try {
            Thread.sleep(10 * 1000);
            producerThread.stop();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
