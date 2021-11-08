package com.sparta.pom.pages;

import org.openqa.selenium.WebDriver;

public class WidgetsPage extends AbstractPage{



    public WidgetsPage(WebDriver webDriver) {
        setWebDriver(webDriver);
    }



    public boolean matchingURL(){
        return getPageUrl().equals("https://demoqa.com/widgets");
    }
}
