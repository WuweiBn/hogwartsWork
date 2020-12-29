package com.hogwarts.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class TestCase {
    public List<String> data;
    public List<HashMap<String, Object>> steps;
    private ChromeDriver driver;
    private WebElement currentElement;

    public void run() {
        steps.forEach(step -> {
            if (step.keySet().contains("chrome")) {
                driver = new ChromeDriver();
            }
            if (step.keySet().contains("implicitly_Wait")) {
                driver.manage().timeouts().implicitlyWait(
                        (int) step.getOrDefault("implicitly_Wait", 5), TimeUnit.SECONDS);
            }
            if (step.keySet().contains("get")) {
                driver.get(step.get("get").toString());
            }
            if (step.keySet().contains("find")) {
                AtomicReference<By> by = null;
                ArrayList<By> bys = new ArrayList<>();
                ((HashMap<String, String>) step.get("find")).entrySet().forEach(StringEntity -> {
                    if (StringEntity.getKey().equals("id")) {
                        bys.add(By.id(StringEntity.getValue()));
                    }
                    if (StringEntity.getKey().equals("xpath")) {
                        bys.add(By.xpath(StringEntity.getValue()));
                    }
                });
                currentElement = driver.findElement(bys.get(0));
            }
            if (step.keySet().contains("click")) {
                currentElement.click();
            }
            if (step.keySet().contains("send_keys")) {
                currentElement.sendKeys("search demo");
            }
        });
    }
}
