package com.hogwarts.appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class BasePageApp {
    AppiumDriver driver;

    public BasePageApp(AppiumDriver driver) {
        this.driver = driver;
    }

    public BasePageApp() {

    }

    public void appClick(By by) {
        driver.findElement(by).click();
    }

    public void appSendKeys(By by, String string) {
        driver.findElement(by).sendKeys(string);
    }

    public void seleep() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
