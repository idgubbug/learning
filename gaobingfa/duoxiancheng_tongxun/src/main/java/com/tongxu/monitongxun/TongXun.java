package com.tongxu.monitongxun;

/**
 * @program: gaobingfa
 * @description: 模拟多线程之间的通讯
 * @author: Mr.huang
 * @create: 2019-05-15 18:11
 **/
class Res {
    public String userSex;
    public String userName;
}

class IntThread extends Thread {
    private Res res;

    public IntThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res) {

                if (count == 0) {
                    res.userName = "余胜军";
                    res.userSex = "男";
                } else {
                    res.userName = "小紅";
                    res.userSex = "女";
                }
                count = (count + 1) % 2;
                System.out.println("设置了:" + res.userName + "," + res.userSex);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class OutThread extends Thread {
    private Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                System.out.println(res.userName + "-------" + res.userSex);

            }
        }
    }
}

/**
 * @Description: 模拟多线程之间的通讯, 但是有线程安全问题, 在不同类的通讯,
 * 但是并不能写一个读取一个,需要wait,nofity实现
 * 要用wait,notify解决问题
 * @Param: * @param null
 * @return:
 * @Author: Mr.huang
 * @Date: 2019/5/15
 **/
public class TongXun {
    public static void main(String[] args) throws InterruptedException {
        Res res = new Res();
        IntThread intThread = new IntThread(res);
        OutThread outThread = new OutThread(res);
        intThread.start();
        outThread.start();
    }
}
