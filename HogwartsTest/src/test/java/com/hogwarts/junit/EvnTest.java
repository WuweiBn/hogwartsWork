package com.hogwarts.junit;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EvnTest {

    @Test
    public void evnTest() {
        assertAll("断言",
                () -> assertEquals(1, 2),
                () -> assertEquals(2, 3)
        );
    }

    @Test
    void ma() {
        System.out.println(1);
    }
}
