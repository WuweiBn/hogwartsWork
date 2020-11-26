package com.hogwarts.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ContactTest {

    public static WebDriver driver;

    public static void needLogin() throws IOException, InterruptedException {
        //扫码登陆
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");

        //等待20秒
        Thread.sleep(20000);
        //获取cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        //创建一个yaml文件
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //将cookies存入yaml文件中
        mapper.writeValue(new File("cookies.yaml"), cookies);
        System.out.println(0);

    }

    @BeforeAll
    public static void beforeAll() throws IOException, InterruptedException {

        File file = new File("cookies.yaml");

        if (file.exists()) {
            //利用cooking复用session扫码登录
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://work.weixin.qq.com/wework_admin/frame");

            //读取cookie
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {
            };

            List<HashMap<String, Object>> cookies = (List<HashMap<String, Object>>) mapper.readValue(file, typeReference);
            System.out.println(cookies);

            //重新设置cooki
            cookies.forEach(cookieMap -> {
                        driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
                    }
            );
            Thread.sleep(5000);
            //刷新页面
            driver.navigate().refresh();

        } else {
            needLogin();
        }

    }

    @Test
    void contackadd() {
        driver.findElement(By.xpath("//*[@id=\"_hmt_click\"]/div[1]/div[4]/div[2]/a[1]/div/span[2]")).click();
        driver.findElement(By.name("username")).sendKeys("Wuweibin");
        driver.findElement(By.name("acctid")).sendKeys("weibin");
        driver.findElement(By.xpath("//*[@id=\"memberAdd_mail\"]")).sendKeys("752061536@qq.com");
        driver.findElement(By.xpath("//*[@id=\"memberAdd_acctid\"]")).sendKeys("Nb151112");
        driver.findElement(By.xpath("//*[@id=\"js_contacts408\"]/div/div[2]/div/div[4]/div/form/div[3]/a[2]")).click();

    }

    @Test
    void contackadd2() {
        click(By.xpath("//*[@id=\"_hmt_click\"]/div[1]/div[4]/div[2]/a[1]/div/span[2]"));
        sendKeys(By.name("username"), "WUweibin");
        sendKeys(By.name("acctid"), "weibin");
        sendKeys(By.xpath("//*[@id=\"memberAdd_mail\"]"), "752061536@qq.com");
        sendKeys(By.xpath("//*[@id=\"memberAdd_acctid\"]"), "Nb151112");
        click(By.xpath("//*[@id=\"js_contacts408\"]/div/div[2]/div/div[4]/div/form/div[3]/a[2]"));

    }

    void click(By by) {
        driver.findElement(by).click();
    }

    void sendKeys(By by, String string) {
        driver.findElement(by).sendKeys(string);
    }


    @AfterAll
    public static void closees() {
//        driver.quit();
    }

}
