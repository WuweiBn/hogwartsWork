package com.hogwarts.appium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class ContactpageAppTest {

    private static ManpageApp manpageApp;

    @BeforeAll
    public static void before() throws MalformedURLException {
        manpageApp = new ManpageApp();
    }

    /*
     * 增加成员
     * */
    @Test
    public void memberAdd() {
        String name = "兔tt";
        Assertions.assertEquals(name, manpageApp.contactPageApp().memberAdd(name, "18911411111").memberSearch(name).getCurrentDepartName());
    }

    /*
     *搜索成员
     */
    @Test
    public void memberSearch() {
        manpageApp.contactPageApp().memberSearch("武威彬");
    }

    /*
     *更新成员
     */
    @Test
    public void memberUpdate() {
        manpageApp.contactPageApp().memberUpdate("");
    }

    /*
     *删除成员
     */
    @Test
    public void memberDelete() {
        manpageApp.contactPageApp().memberDelete();
    }

    /*
     * 增加部门
     * */
    @Test
    void departAdd() {
        String name = "第四期12111";
        Assertions.assertEquals(name, manpageApp.contactPageApp().departAdd(name).memberSearch("12111").getCurrentDepartName());
    }

}
