package com.builder;

/**
 * @program: factory-partter
 * @description: 组装各个部分
 * @author: Mr.huang
 * @create: 2019-05-16 13:59
 **/
public class PersonDirector {
    //开始组装
    public Person constructPerson(PersonBuilder pb) {
        pb.builderHead();
        pb.builderBody();
        pb.builderFoot();
        return pb.BuilderPersion();
    }

    /**
     * @Description: Director（调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息
     * ，只负责保证对象各部分完整创建或按某种顺序创建）
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/16 14:03
     **/
    public static void main(String[] args) {
        //调用
        PersonDirector pb = new PersonDirector();
        //传入参数
        Person person = pb.constructPerson(new ManBuilder(new Person()));
        //使用
        System.out.println(person.getHead());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());
    }
}
