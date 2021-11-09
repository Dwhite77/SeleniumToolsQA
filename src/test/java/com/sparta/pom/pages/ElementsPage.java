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
        return matchingSuper("userName",testInput, By.id("name"), "Name:"+testInput );
    }

    public boolean matchingTextBoxEmail(){

        return matchingSuper("userEmail","test@test.com",  By.id("email"),"Email:test@test.com" );
    }

    public boolean matchingTextBoxAddress(){
        return matchingSuper("currentAddress","test", By.cssSelector(".border > #currentAddress"),"Current Address :test" );
    }

    public boolean matchingSuper(String boxId, String input,  By findResult, String compareResult){
        getWebDriver().findElement(By.id("item-0")).click();
        getWebDriver().findElement(By.id(boxId)).click();
        getWebDriver().findElement(By.id(boxId)).sendKeys(input);
        getWebDriver().findElement(By.id("submit")).click();
        getWebDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String result = getWebDriver().findElement(findResult).getText();
        return result.equals(compareResult);
    }

}
