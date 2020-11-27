package com.hogwarts.web;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPOTest {

    @Test
    void testAddmember() throws IOException, InterruptedException {
        //打开页面
        //复用session登录
        MainPage mainPage = new MainPage();
        //跳转页面
        //添加成员
        Contactpage contactpage = mainPage.contact();
//        contactpage.addMember("zhangsan", "12345", "15600009878");
        contactpage.searchDepart("小牛猪");
        String content = contactpage.getPartyInfo();
        assertTrue(content.contains("无任何成员"));
    }

    @Test
    void testAddmember1() throws IOException, InterruptedException {

        assertTrue(new MainPage().contact().searchDepart("小牛猪").getPartyInfo().contains("无任何成员"));
    }

}