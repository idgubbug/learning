package com.tongxu.tongxun3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: gaobingfa
 * @description: condition的用法
 * @author: Mr.huang
 * @create: 2019-05-15 20:20
 **/
class res {
    public String userName;
    public String sex;
    public boolean flag = false;
    Lock lock = new ReentrantLock();
}

class inputThread extends Thread {
    private res res;
    private Condition condition;

    public inputThread(res res, Condition condition) {
        this.res = res;
        this.condition = condition;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {

            try {
                res.lock.lock();
                if (res.flag) {
                    try {
                        //暂停
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count == 0) {
                    res.userName = "余胜军";
                    res.sex = "男";
                } else {
                    res.userName = "小红";
                    res.sex = "女";
                }
                count = (count + 1) % 2;
                Thread.sleep(1000);
                res.flag = true;
                //				res.notify();
                //唤醒
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }

        }
    }
}

class outThread extends Thread {
    private res res;
    private Condition condition;

    public outThread(res res, Condition condition) {
        this.res = res;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true) {

            try {
                res.lock.lock();
                if (!res.flag) {
                    try {
                        condition.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //				res.notify();
                condition.signal();
                System.out.println(res.userName + "," + res.sex);
                res.flag = false;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

/**
 * @Description: lock锁是手动锁, 要手动上锁和手动解锁, lock和condition一起结合使用可以有wait, notify的功能
 * @Param: * @param null
 * @return:
 * @Author: Mr.huang
 * @Date: 2019/5/15
 **/
public class ConditionThread {
    public static void main(String[] args) {
        res res = new res();
        Condition condition = res.lock.newCondition();
        inputThread inputThread = new inputThread(res, condition);
        outThread outThread = new outThread(res, condition);
        inputThread.start();
        outThread.start();
    }
}
