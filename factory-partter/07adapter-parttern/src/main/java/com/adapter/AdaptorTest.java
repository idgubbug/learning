package com.adapter;

/**
 * @Description: 适配器模式
 * @Param: * @param null
 * @return:
 * @Author: Mr.huang
 * @Date: 2019/5/16 14:29
 **/
public class AdaptorTest {
    /**
     * @Description: 适配使得因接口不兼容而不能在一起工作的类工作在一起，
     * 做法是将类自己的接口包裹在一个已存在的类中
     * 使用场景:
     * 1、我们在使用第三方的类库，或者说第三方的API的时候，我们通过适配器转换来满足现有系统的使用需求。
     * 2、我们的旧系统与新系统进行集成的时候，我们发现旧系统的数据无法满足新系统的需求，那么这个时候，我们可能需要适配器，完成调用需求。
     * 3、我们在使用不同数据库之间进行数据同步。(我这里只是分析的是通过程序来说实现的时候的情况。还有其他的很多种方式[数据库同步])。
     * <p>
     * <p>
     * OutputStreamWriter：是Writer的子类，将输出的字符流变为字节流，即：将一个字符流的输出对象变为字节流的输出对象。
     * InputStreamReader：是Reader的子类，将输入的字节流变为字符流，即：将一个字节流的输入对象变为字符流的输入对象。
     * SpringMVC 适配器
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/16 14:33
     **/
    public static void main(String[] args) {
        CN220VInterface cn220VInterface = new CN220VInterfaceImpl();
        PowerAdaptor powerAdaptor = new PowerAdaptor(cn220VInterface);
        // 电饭煲
        ElectricCooker cooker = new ElectricCooker(powerAdaptor);
        cooker.cook();//使用了适配器,在220V的环境可以工作了。
    }

}
