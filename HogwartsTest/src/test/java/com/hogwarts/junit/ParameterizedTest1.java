package com.hogwarts.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParameterizedTest1 {
    WebDriver driver = new ChromeDriver();
   @Test
    public void aaa(){
        driver.get("http://10.117.3.249:8808/#/login");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[3]/input")).clear();
    }
}
