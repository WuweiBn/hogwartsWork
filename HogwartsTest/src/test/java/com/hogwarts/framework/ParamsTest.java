package com.hogwarts.framework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


public class ParamsTest {
    WebDriver driver = new ChromeDriver();

    @DisplayName("使用@ValueSource注解参数化")
    @ParameterizedTest
    @ValueSource(strings = {"阿信", "寺韩"})
    void paramsTest(String name) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ceshiren.com");
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys(name);
    }

    @DisplayName("通过读取Yaml数据驱动参数化1")
    @ParameterizedTest
    @MethodSource("Provider")
    void paramsTest1(String keywords) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ceshiren.com");
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys(keywords);
    }

//    static Stream<String> Provider() {
//        return Stream.of("apple", "banana","lnb","w");
//    }

    @DisplayName("通过读取Yaml数据驱动参数化1")
    static List<String> Provider() throws IOException {
//        return Stream.of("apple", "banana","lnb","w");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<String>> typeReference = new TypeReference<List<String>>() {
        };
        List<String> keywords = (List<String>) mapper.readValue(
                ParamsTest.class.getResourceAsStream("/framework/search.yaml"),
                typeReference);
        return keywords;
    }

    @DisplayName("通过读取Yaml数据驱动参数化2")
    @ParameterizedTest
    @MethodSource("Provider1")
    void paramsTest2(TestCase testCase) {
        System.out.println(testCase);
        testCase.run();
    }

    @DisplayName("通过读取Yaml数据驱动参数化2")
    static Stream<TestCase> Provider1() throws IOException {
//        return Stream.of("apple", "banana","lnb","w");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<String>> typeReference = new TypeReference<List<String>>() {
        };
        TestCase testCase = mapper.readValue(
                ParamsTest.class.getResourceAsStream("/framework/search.yaml"),
                TestCase.class);
        return Stream.of(testCase);
    }

}
