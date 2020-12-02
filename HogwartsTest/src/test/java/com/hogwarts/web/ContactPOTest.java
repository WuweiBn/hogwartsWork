package com.hogwarts.web;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPOTest {

    private static MainPage mian;
    private static String departName = "Bn_test";

    @BeforeAll
    static void befoer() throws IOException, InterruptedException {
        mian = new MainPage();
    }

    /*
     * 搜索部门
     * */
    @Order(2)
    @Test
    void testAddmember() throws IOException, InterruptedException {

        assertTrue(mian.contact().searchDepart(departName).getPartyInfo().contains("无任何成员"));
    }

    /*
     * 添加部门
     * */
    @Order(1)
    @Test
    void testDepartAdd() {

        assertTrue(mian.contact().addDepart(departName).searchDepart(departName).getPartyInfo().contains(departName));
    }

    /*
     * 删除部门
     * */
    @Order(3)
    @Test
    void deleteDepart() throws InterruptedException {
        assertTrue(mian.contact().deleteDepart(departName).searchDepart(departName).getPartyInfo().contains("尹侦测试账号(95人)"));
    }

    /*
     * 更新部门
     * */
    @Test
    void updateDepart() {
        String updateName = departName + "1";
        assertTrue(mian.contact().updatDepart(departName).searchDepart(updateName).getPartyInfo().contains(updateName));
    }

    /*
     * 添加成员
     * */
    @Test
    void memberAdd() {
        assertTrue(mian.contact().addMember("图图", "468", "18911004040")
                .searchDepart("图图").getPartyInfo().contains("图图"));
    }

    /*
     * 编辑成员
     * */
    @Test
    void updatMember() {
        assertTrue(mian.contact().updatMember("图图").searchDepart("特图").getPartyInfo().contains("特图"));
    }

}