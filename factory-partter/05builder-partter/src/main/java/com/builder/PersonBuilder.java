package com.builder;

/**
 * @program: factory-partter
 * @description: ${description}
 * @author: Mr.huang
 * @create: 2019-05-16 13:56
 **/
/**
* @Description: Builder（给出一个抽象接口，以规范产品对象的各个组成成分的建造。
 * 这个接口规定要实现复杂对象的哪些部分的创建，并不涉及具体的对象部件的创建）
* @Param:  * @param null
* @return:
* @Author: Mr.huang
* @Date: 2019/5/16 13:57
**/
public interface PersonBuilder {
    void builderHead();

    void builderBody();

    void builderFoot();

    Person BuilderPersion(); //组装
}
