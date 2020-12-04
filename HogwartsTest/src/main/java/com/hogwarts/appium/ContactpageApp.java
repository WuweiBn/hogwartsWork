package com.hogwarts.appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ContactpageApp extends BasePageApp {

    public ContactpageApp(AppiumDriver driver) {
        super(driver);
    }

    public ContactpageApp memberAdd(String username, String phone) {
        appClick(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[18]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"));
        seleep();
        appClick(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.LinearLayout"));
        appSendKeys(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.EditText"), username);
        appSendKeys(By.id("fow"), phone);
        appClick(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[6]/android.widget.RelativeLayout/android.widget.RelativeLayout"));
        seleep();
        appClick(By.id("gsh"));
        appClick(By.id("i6k"));
        return this;

    }

    public ContactpageApp memberSearch(String name) {
        appClick(By.id("i6n"));
        appSendKeys(By.id("gpg"), name);
        return this;

    }

    public ContactpageApp memberUpdate(String departName) {

        return this;

    }

    public ContactpageApp memberDelete() {

        return this;

    }


}
