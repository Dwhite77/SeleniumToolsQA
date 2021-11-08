package com.sparta.pom.pages;

import org.openqa.selenium.WebDriver;

public class InteractionsPage extends AbstractPage{


    public InteractionsPage(WebDriver webDriver) {
        setWebDriver(webDriver);
    }


    public boolean matchingURL(){
        return getPageUrl().equals("https://demoqa.com/interaction");
    }
}
