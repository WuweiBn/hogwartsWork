package com.packageC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClassCTest {

    @Test
    public void testSe(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }
}
