package com.hogwarts.junit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class Junit5Test {

    @Test
    void addition() {
        int result = Junit5_Test.addition(8, 4);
        System.out.println(8 + "+" + 4 + " = " + result);
        Assert.assertEquals(12, result);
    }

    @Test
    void Subtraction() {
        int result = Junit5_Test.Subtraction(8, 4);
        System.out.println(8 + "-" + 4 + " = " + result);
        Assert.assertEquals(4, result);
    }

    @Test
    void multiplication() {
        int result = Junit5_Test.multiplication(8, 4);
        System.out.println(8 + "*" + 4 + " = " + result);
        Assert.assertEquals(32, result);
    }

    @Test
    void division() {
        int result = Junit5_Test.division(8, 4);
        System.out.println(8 + "/" + 4 + " = " + result);
        Assert.assertEquals(2, result);
    }


    @Test
    void counts() {
        int result = Junit5_Test.count(1);
        result = Junit5_Test.count(1);
        result = Junit5_Test.count(1);
        System.out.println(result);

    }

    @Test
    void lmd() {
        int result = Junit5_Test.addition(8, 4);
        assertAll("",
                () -> Assert.assertEquals("结果断言", 20, result),
                () -> Assert.assertEquals("结果断言", 30, result),
                () -> Assert.assertEquals("结果断言", 12, result),
                () -> Assert.assertEquals("结果断言", 70, result)
        );
    }
}
