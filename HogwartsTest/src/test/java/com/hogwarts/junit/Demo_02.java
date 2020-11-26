package com.hogwarts.junit;

import org.junit.jupiter.api.*;

public class Demo_02 extends Demo_01 {

    @Test
    void fan() {
        System.out.println("子类: Test1");
    }

    @BeforeAll
    static void fan2() {
        System.out.println("子类: BeforeAll");
    }

    @AfterAll
    static void fan3() {
        System.out.println("子类: AfterAll");
    }

    @BeforeEach
    void fan4() {
        System.out.println("子类: BeforeEach");
    }

    @AfterEach
    void fan5() {
        System.out.println("子类: AfterEach");
    }
}
