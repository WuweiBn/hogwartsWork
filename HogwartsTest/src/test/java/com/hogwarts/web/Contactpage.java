package com.hogwarts.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contactpage extends BasePage {

    //PO原则2  不要暴漏y页面细节
    private By parterInfo = By.cssSelector(".js_party_info");

    public Contactpage(WebDriver driver) {
    //保存driver到自己的实例
        super(driver);
    }
    //PO原则6 添加成功的时候与添加失败返回的页面是不同的，需要封装为不同的方法
    public Contactpage addMember(String username, String acctId, String mobile) {
        return this;
    }
    //PO原则6 添加失败返回的页面是不同的，需要封装为不同的方法
    public Contactpage addMemberFail(String username, String acctId, String mobile) {
        return this;
    }

    //PO原装5 不要实现所有的方法，按需封装
    public Contactpage searchDepart(String departName) {
        //PO原则1 用公共方法代表页面所提供功能
        //Po原则3 通常不要在Po方法内添加断言
        sendKeys(By.id("memberSearchInput"), "小牛猪");
        String content = driver.findElement(parterInfo).getText();
        System.out.println("第一次获取:" + content);
        click(By.cssSelector(".ww_icon_AddMember.ww_icon_AddMember"));
        return this;
    }

    public String getPartyInfo() {
        String content = driver.findElement(parterInfo).getText();
        System.out.println("第二次获取:" + content);
        return content;

    }

}
