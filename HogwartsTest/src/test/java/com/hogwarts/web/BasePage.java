package com.hogwarts.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void click(By by) {
        driver.findElement(by).click();
    }

    void sendKeys(By by, String string) {
        driver.findElement(by).sendKeys(string);
    }
}
