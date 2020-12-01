package com.hogwarts.web;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPOTest {

    private static MainPage mian;

    @BeforeAll
    static void befoer() throws IOException, InterruptedException {
        mian = new MainPage();
    }

    /*
     * 搜索部门
     * */
    @Test
    void testAddmember() throws IOException, InterruptedException {

        assertTrue(mian.contact().searchDepart("小牛猪").getPartyInfo().contains("无任何成员"));
    }

    /*
     * 添加部门
     * */
    @Test
    void testDepartAdd() {

        String departName = "Bn_test";
        assertTrue(mian.contact().addDepart(departName).searchDepart(departName).getPartyInfo().contains(departName));
    }

    @Test
    void deleteDepart() throws InterruptedException {
        mian.contact().clearDepart("小牛猪");
    }

}