package com.packageA;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;

public class ClassATest {

    @Test(groups = {"group01"})
    @Description("testCaseA01 inside ClassATest inside packageA")
    public void testCaseA01() {
        System.out.println("testCaseA01 inside ClassATest inside packageA");
    }

    @Test(groups = {"group02,group03"})
    @Description("testCaseA02 inside ClassATest inside packageA")
    public void testCaseA02() {
        System.out.println("testCaseA02 inside ClassATest inside packageA");
    }

    @Test(groups = {"group03"})
    @Description("testCaseA03 inside ClassATest inside packageA")
    public void testCaseA03() {
        System.out.println("testCaseA03 inside ClassATest inside packageA");
    }
}
