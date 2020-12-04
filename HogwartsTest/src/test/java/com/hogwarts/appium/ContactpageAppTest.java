package com.hogwarts.appium;

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
        manpageApp.contactPageApp().memberAdd("蛋蛋", "18911430000");
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
}
