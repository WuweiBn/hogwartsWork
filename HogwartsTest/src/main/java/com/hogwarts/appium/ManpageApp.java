package com.hogwarts.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ManpageApp extends BasePageApp {
    DesiredCapabilities caps = new DesiredCapabilities();

    public void loginWx() throws MalformedURLException {

        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "127.0.0.1:7555");
        caps.setCapability("appPackage", "com.tencent.wework");
        caps.setCapability("appActivity", ".launch.LaunchSplashActivity");
        caps.setCapability("noReset", "true");
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        seleep();
    }

    public ManpageApp() throws MalformedURLException {
        super();
        this.loginWx();
    }


    public ContactpageApp contactPageApp() {
        //进入通讯录界面
        appClick(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView"));
        return new ContactpageApp(driver);
    }
}
