package com.hogwarts.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contactpage {
    private WebDriver driver;

    public Contactpage(WebDriver driver) {
        this.driver = driver;
    }

    public Contactpage addMember(String username, String acctId, String mobile) {
        return this;
    }

    public Contactpage searchDepart(String departName) {
        sendKeys(By.id("memberSearchInput"), "小牛猪");
        String content = driver.findElement(By.cssSelector(".js_party_info")).getText();
        System.out.println("第一次获取:" + content);
        click(By.cssSelector(".ww_icon_AddMember.ww_icon_AddMember"));
        return this;
    }

    public String getPartyInfo() {
        String content = driver.findElement(By.cssSelector(".js_party_info")).getText();
        System.out.println("第二次获取:" + content);
        return content;

    }

    void click(By by) {
        driver.findElement(by).click();
    }

    void sendKeys(By by, String string) {
        driver.findElement(by).sendKeys(string);
    }
}
