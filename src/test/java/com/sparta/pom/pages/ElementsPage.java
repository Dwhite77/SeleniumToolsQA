package com.sparta.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ElementsPage extends AbstractPage{


    public ElementsPage(WebDriver webDriver) {
        setWebDriver(webDriver);
    }

    public boolean matchingURL(){
        return getPageUrl().equals("https://demoqa.com/elements");
    }

    public boolean matchingTextBoxName(String testInput){
        getWebDriver().findElement(By.id("item-0")).click();
        getWebDriver().findElement(By.id("userName")).click();
        getWebDriver().findElement(By.id("userName")).sendKeys(testInput);
        getWebDriver().findElement(By.id("submit")).click();
        getWebDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String result = getWebDriver().findElement(By.id("name")).getText();
        return result.equals("Name:"+testInput);
    }

    public boolean matchingTextBoxEmail(){
        getWebDriver().findElement(By.id("item-0")).click();
        getWebDriver().findElement(By.id("userEmail")).click();
        getWebDriver().findElement(By.id("userEmail")).sendKeys("test@test.com");
        getWebDriver().findElement(By.id("submit")).click();
        getWebDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String result = getWebDriver().findElement(By.id("email")).getText();
        return result.equals("Email:test@test.com");
    }

    public boolean matchingTextBoxAddress(){
        getWebDriver().findElement(By.id("item-0")).click();
        getWebDriver().findElement(By.id("currentAddress")).click();
        getWebDriver().findElement(By.id("currentAddress")).sendKeys("test");
        getWebDriver().findElement(By.id("submit")).click();
        getWebDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String result = getWebDriver().findElement(By.cssSelector(".border > #currentAddress")).getText();
        return result.equals("Current Address :test");
    }

}
