package com.tongxu.tongxue2;

/**
 * @program: gaobingfa
 * @description: wait, nofity的使用
 * @author: Mr.huang
 * @create: 2019-05-15 18:39
 **/
class res {
    public String userSex;
    public String userName;
    public boolean flag = false;
}

class IntThread extends Thread {
    private res res;

    public IntThread(res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res) {

                res.flag = true;
                if (count == 0) {
                    res.userName = "余胜军";
                    res.userSex = "男";
                } else {
                    res.userName = "小紅";
                    res.userSex = "女";
                }
                count = (count + 1) % 2;
                // 唤醒当前线程
                res.notify();
                if (res.flag) {
                    try {
                        //暂停线程,
                        res.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class OutThread extends Thread {
    private res res;

    public OutThread(res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.userName + "--" + res.userSex);
                res.flag = false;
                res.notify();
            }
        }
    }
}

/**
 * @Description: 实现通讯, 一个生产一个消费, wait表示暂停并释放锁, 等待notify的唤醒, notify唤醒线程
 * @Param: * @param null
 * @return:
 * @Author: Mr.huang
 * @Date: 2019/5/15
 **/
public class TongXun2 {
    public static void main(String[] args) {
        res res = new res();
        IntThread intThread = new IntThread(res);
        OutThread outThread = new OutThread(res);
        intThread.start();
        outThread.start();
    }
}
