package com.hogwarts.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HelloAppium {
    public static AppiumDriver driver;

    @BeforeAll
    static void appiumbefor() {
        try {

            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "127.0.0.1:7555");
            caps.setCapability("appPackage", "com.tencent.wework");
            caps.setCapability("appActivity", ".launch.LaunchSplashActivity");
            caps.setCapability("noReset", "true");

            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Test
    void appium() {
        driver.navigate().back();
        MobileElement el1 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el1.click();
        el1.sendKeys("阿里巴巴");
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        el2.click();
    }

    @Test
    void search() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("i6n")).click();
        driver.findElement(By.id("gpg")).sendKeys("sihan");

    }
}
