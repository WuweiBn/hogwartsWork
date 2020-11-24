package com.hogwarts.demo;

import org.junit.jupiter.api.RepeatedTest;

public class Junit5_Parallel {

    @RepeatedTest(10)
    void counts() throws InterruptedException {
        int result = Junit5_Test.count(1);
        System.out.println(result);

    }

    @RepeatedTest(10)
    public  void   syncounts() throws InterruptedException {
        int result = Junit5_Test.syncount(1);
        System.out.println(result);

    }
}
