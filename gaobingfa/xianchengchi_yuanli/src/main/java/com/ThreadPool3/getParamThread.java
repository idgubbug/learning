package com.ThreadPool3;

import java.util.concurrent.*;

/**
 * @program: gaobingfa
 * @description: callable和futrue共同获取线程的返回值
 * @author: Mr.huang
 * @create: 2019-05-15 22:20
 **/
class AddNumberTask implements Callable<Integer> {

    public AddNumberTask() {

    }

    public Integer call() throws Exception {
        System.out.println("####AddNumberTask###call()");
        Thread.sleep(5000);
        return 5000;
    }

}

public class getParamThread {
    /**
     * @Description: callable和futrue共同获取线程的返回值,
     * 类实现callable<v>,重写call()方法,相当于线程中的run()方法,可以带返回值
     * 创建一个线程池,可以用executors,也可以用ThreadPoolExecutor
     * .submit(callable的实现类的实例化).get()获取返回值
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new AddNumberTask());
        System.out.println(Thread.currentThread().getName() + "线程执行其他任务");
        Integer integer = future.get();
        System.out.println(integer);
        // 关闭线程池
        if (executor != null) {
            executor.shutdown();
        }*/


        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<Integer> futrue = newCachedThreadPool.submit(new AddNumberTask());
        System.out.println(Thread.currentThread().getName() + "线程执行其他任务");
        Integer integer = futrue.get();
        System.out.println(integer);
        if (newCachedThreadPool != null) {
            newCachedThreadPool.shutdown();
        }
    }
}
