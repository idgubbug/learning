package com.lock.reentrantLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: gaobingfa
 * @description: 读写锁机制
 * @author: Mr.huang
 * @create: 2019-05-15 22:51
 **/
public class ReadAndWriteLock {
    //存放数据的集合
    static Map<String, Object> map = new HashMap<String, Object>();
    //实例化读写锁
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    //读写锁中分出读锁
    static Lock r = rwl.readLock();
    //写锁
    static Lock w = rwl.writeLock();

    public static final Object get(String key) {
        //读的时候上读锁
        r.lock();
        try {
            System.out.println("正在做读的操作,key:" + key + " 开始");
            Thread.sleep(100);
            Object object = map.get(key);
            System.out.println("正在做读的操作,key:" + key + " 结束");
            System.out.println();
            return object;
        } catch (InterruptedException e) {

        } finally {
            //释放
            r.unlock();
        }
        return key;
    }

    public static final Object put(String key, Object value) {
        //写的时候上写锁
        w.lock();
        try {

            System.out.println("正在做写的操作,key:" + key + ",value:" + value + "开始.");
            Thread.sleep(100);
            Object object = map.put(key, value);
            System.out.println("正在做写的操作,key:" + key + ",value:" + value + "结束.");
            System.out.println();
            return object;
        } catch (InterruptedException e) {

        } finally {
            //释放
            w.unlock();
        }
        return value;
    }

    //清除数据
    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

    /**
     * @Description: 读写锁, 读的时候上read锁, 写的时候上write锁, 操作完毕后到释放锁, unlock
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15 22:57
     **/
    public static void main(String[] args) {
        //启动写线程 写完后 在启动读线程
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ReadAndWriteLock.put(i + "", i + "");
                }

            }
        }).start();
        //启动读线程
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ReadAndWriteLock.get(i + "");
                }

            }
        }).start();
    }
}
