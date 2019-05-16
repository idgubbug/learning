package com.builder;

/**
 * @program: factory-partter
 * @description: 实现Builder接口
 * @author: Mr.huang
 * @create: 2019-05-16 13:58
 **/

/** 
* @Description:  ConcreteBuilder（实现Builder接口，针对不同的商业逻辑，
 * 具体化复杂对象的各部分的创建。 在建造过程完成后，提供产品的实例）
* @Param:  * @param null 
* @return:  
* @Author: Mr.huang
* @Date: 2019/5/16 13:59 
**/ 
public class ManBuilder implements PersonBuilder {
    private Person person;


    public ManBuilder(Person person) {
        this.person = person;
    }

    public void builderHead() {
        person.setHead("建造者头部分");
    }

    public void builderBody() {
        person.setBody("建造者身体部分");
    }

    public void builderFoot() {
        person.setFoot("建造者头四肢部分");
    }

    public Person BuilderPersion() {
        return person;
    }
}
