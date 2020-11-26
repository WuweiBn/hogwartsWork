package com.hogwarts.junit;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;


@Epic("Epic 计算器项目")
@Feature("Feature 冒烟测试用例")
public class Junit5_Allure {

    @Test
    @Description("Description")
    @Story("Story 加法测试")
    @DisplayName("DisplayName 加法测试")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("www.baidu.com")
    @Link(name = "Link 社区帖", type = "mylink", url = "ceshiren.com")
    void addition() {
        int result1 = Junit5_Test.addition(8, 4);
        System.out.println(8 + "+" + 4 + " = " + result1);


        int result2 = Junit5_Test.Subtraction(8, 4);
        System.out.println(8 + "-" + 4 + " = " + result2);


        int result3 = Junit5_Test.multiplication(8, 4);
        System.out.println(8 + "*" + 4 + " = " + result3);


        int result4 = Junit5_Test.division(8, 4);
        System.out.println(8 + "/" + 4 + " = " + result4);


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

    @Test
    void pic() {
        Junit5_Test.division(1,2);
        System.out.println();
        Allure.addAttachment("car", "image/png", this.getClass().getResourceAsStream("/car.png"), ".png");

    }

}
