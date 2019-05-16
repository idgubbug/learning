package com.clone.demo1;

import java.util.ArrayList;

/**
 * @program: factory-partter
 * @description: 实体类
 * @author: Mr.huang
 * @create: 2019-05-16 15:03
 **/
public class Book {
    private String title;
    private ArrayList<String> listImg = new ArrayList<String>();
    private int age;

    public void addImg(String imgName) {
        listImg.add(imgName);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getListImg() {
        return listImg;
    }

    public void setListImg(ArrayList<String> listImg) {
        this.listImg = listImg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showBook() {
        System.out.println("...............start..............");
        System.out.println("title:" + title);
        for (String imgs : listImg) {
            System.out.println("img name :" + imgs + " ");
        }
        System.out.println("age:" + this.age);
        System.out.println("...............end..............");
    }
}
