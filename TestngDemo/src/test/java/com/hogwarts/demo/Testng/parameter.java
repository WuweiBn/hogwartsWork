package com.hogwarts.demo.Testng;

import com.hogwarts.demo.TestngDemo;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameter {

    @Test
    @Parameters({"x","y","z"})
    public void add(int x,int y,int z){
        int b = TestngDemo.addition(x,y);
        Assert.assertEquals(b,z);
        System.out.println(z);


    }
}
