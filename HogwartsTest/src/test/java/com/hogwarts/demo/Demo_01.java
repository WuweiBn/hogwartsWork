package com.hogwarts.demo;

import org.junit.jupiter.api.*;

public class Demo_01 {

    @Test
    void fun1() {
        System.out.println("父类：Test1");
    }

    @Test
    void fun2() {
        System.out.println("父类：Test2");
    }


    @BeforeAll
    static void fun_3() {
        System.out.println("父类：BeforeAll");
    }

    @AfterAll
    static void fun_4() {
        System.out.println("父类：AfterAll");
    }

    @BeforeEach
    void fun_5() {
        System.out.println("父类：BeforeEach");
    }

    @AfterEach
    void fun_6() {
        System.out.println("父类：AfterEach");
    }
}
