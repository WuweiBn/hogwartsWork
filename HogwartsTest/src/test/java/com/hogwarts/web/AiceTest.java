package com.hogwarts.web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

public class AiceTest {

    public static WebDriver driver;
    public static Actions actions;

    @BeforeAll
    public static void initDate() {
//        System.setProperty("webdriver.chrome.driver", "D:\\baidu\\hogwarts\\chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    void login() {
        driver.get("https://ceshiren.com/");

        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        driver.findElement(By.id("login-account-name")).clear();
        driver.findElement(By.id("login-account-name")).sendKeys("15311959310@163.com");
        driver.findElement(By.id("login-account-password")).clear();
        driver.findElement(By.id("login-account-password")).sendKeys("20151112nb");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    void dokypay() {
        driver.get("http://10.117.3.249:8808/");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/input")).sendKeys("wuweibin");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[3]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[3]/input")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[5]")).click();

    }


    @Test
    void scrollTest() {

        try {
            driver.get("https://www.baidu.com");
            driver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院");
            actions.click(driver.findElement(By.id("su")));
//            driver.findElement(By.id("su")).click();


            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(4000);

            driver.findElement(By.xpath("//a[@class='n']")).click();
            Thread.sleep(4000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

    }


    @AfterAll
    static void clock() {
//        driver.quit();

    }

}
