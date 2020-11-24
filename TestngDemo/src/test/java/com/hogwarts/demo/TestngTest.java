package com.hogwarts.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngTest {

    @Test(threadPoolSize = 2, invocationCount = 5)
    public void add() {
        int i = TestngDemo.addition(2, 2);
        System.out.println("完成计算，结果为："+i);
        Assert.assertEquals(i, 4);
    }

    @Test(threadPoolSize = 2, invocationCount = 5)
    public void Sub() {
        int i = TestngDemo.Subtraction(2, 2);
        System.out.println("完成计算，结果为："+i);
        Assert.assertEquals(i, 0);
    }

}
