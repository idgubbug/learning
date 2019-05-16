package com.singleton;

//双重检验锁 双重检验锁模式（double checked locking pattern），是一种使用同步块加锁的方法。程序员称其为双重检查锁，因为会有两次检查 instance == null，一次是在同步块外，一次是在同步块内。为什么在同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
public class SingletonDemo04 {
   /* private SingletonDemo04 singletonDemo04 = null;
    private static boolean flag = false;

    private SingletonDemo04() {

        if (flag == false) {
            flag = !flag;
        } else {
            throw new RuntimeException("单例模式被侵犯！");
        }
    }*/

   /* public static void main(String[] args) {
        SingletonDemo04 singleton = new SingletonDemo04();
        SingletonDemo04 s1 = singleton.getInstance();
        SingletonDemo04 s2 = singleton.getInstance();
        System.out.println(s1 == s2);
    }*/

   /* public  SingletonDemo04 getInstance() {
        if (singletonDemo04 == null) {
            synchronized (this) {
                if (singletonDemo04 == null) {
                    singletonDemo04 = new SingletonDemo04();
                }
            }
        }
        return singletonDemo04;
    }*/
   private static boolean flag = false;
    private SingletonDemo04() {
        System.out.println("初始化..");
        if (flag == false) {
            flag = !flag;
        } else {
            throw new RuntimeException("单例模式被侵犯！");
        }
    }

    public static class SingletonClassInstance {
        private static final SingletonDemo04 singletonDemo04 = new SingletonDemo04();
    }

    // 方法没有同步
    public static SingletonDemo04 getInstance() {
        System.out.println("getInstance");
        return SingletonDemo04.SingletonClassInstance.singletonDemo04;
    }

    /**
     * @Description: 静态内部类单例模式
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15 23:29
     **/
    public static void main(String[] args) {
        SingletonDemo04 s1 = SingletonDemo04.getInstance();
        SingletonDemo04 s2 = SingletonDemo04.getInstance();
        System.out.println(s1 == s2);
    }

}