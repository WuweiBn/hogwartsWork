package com.hogwarts.appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ContactpageApp extends BasePageApp {
    private By menu = By.id("i6i");
    private By searchButton = By.id("i6n");
    private By addDepartLocator = By.xpath("//*[@text='添加子部门']");
    private By editText = By.className("android.widget.EditText");
    private By departName = By.xpath("//android.widget.ListView/android.widget.RelativeLayout[2]//android.widget.TextView");
    private By closeButton = By.xpath("//*[contains(@resource-id,'gpf') or contains(@resource-id,'i6d') ]");
    private By back = By.id("i63");

    public ContactpageApp(AppiumDriver driver) {
        super(driver);
    }

    public ContactpageApp memberAdd(String username, String phone) {
        appClick(menu);
//      添加成员的2种定位法
//        appClick(By.id("e30"));
        appClick(By.xpath("//*[@text='添加成员']"));
//      手动输入添加的2种定位法
//        appClick(By.id("cox"));
        appClick(By.xpath("//*[@text='手动输入添加']"));
        appSendKeys(By.id("b4t"), username);
        appSendKeys(By.id("fow"), phone);
        appClick(By.xpath("//*[@text='设置部门']"));
        seleep();
//      确定的2种定位方放
//        appClick(By.id("gsh"));
        appClick(By.xpath("//*[@text='确定(1)']"));
        appClick(By.xpath("//*[@text='保存']"));
        appClick(back);
        appClick(closeButton);
        return this;
    }

    public ContactpageApp memberSearch(String name) {
        appClick(searchButton);
        appSendKeys(editText, name);
        return this;

    }

    public ContactpageApp memberUpdate(String departName) {

        return this;

    }

    public ContactpageApp memberDelete() {

        return this;

    }

    public String getCurrentDepartName() {
        return driver.findElement(departName).getText();
    }

    public ContactpageApp departAdd(String name) {
        appClick(menu);
        appClick(addDepartLocator);
        appSendKeys(editText, name);
        appClick(By.xpath("//*[@text='确定']"));
        appClick(closeButton);
        seleep();
        return this;
    }

}
