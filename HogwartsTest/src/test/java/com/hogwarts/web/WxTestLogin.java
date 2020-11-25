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

public class WxTestLogin {

    public static WebDriver driver;

    @BeforeAll
    public static void beforall(){

        System.out.println("开始执行自动化测试");
    }

    /*
     *登录企业微信并将cookies 写入yaml文件中
     *  */
    @Test
    public void testLogig() throws IOException, InterruptedException {
        driver = new ChromeDriver();
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


    }

    @Test
    public void testLogined() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");

        //读取cookie
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        List<HashMap<String, Object>> cookies = (List<HashMap<String, Object>>) mapper.readValue(new File("cookies.yaml"), typeReference);
        System.out.println(cookies);

        //重新设置cooki
        cookies.forEach(cookieMap -> {
                    driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
                }
        );

        //刷新页面
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"_hmt_click\"]/div[1]/div[4]/div[2]/a[1]/div/span[2]")).click();
        driver.findElement(By.id("username")).sendKeys("Wuweibin");
        driver.findElement(By.id("memberAdd_english_name")).sendKeys("weibin");
        driver.findElement(By.xpath("//*[@id=\"memberAdd_mail\"]")).sendKeys("752061536@qq.com");
        driver.findElement(By.xpath("//*[@id=\"memberAdd_acctid\"]")).sendKeys("Nb151112");
        driver.findElement(By.xpath("//*[@id=\"js_contacts408\"]/div/div[2]/div/div[4]/div/form/div[3]/a[2]")).click();


    }

    @AfterAll
    public static void closees(){
        driver.quit();
    }

}
