package com.sparta.pom.pages;

import org.openqa.selenium.WebDriver;

public class AlertsPage extends AbstractPage{

    public AlertsPage(WebDriver webDriver) {
        setWebDriver(webDriver);
    }


    public boolean matchingURL(){
        return getPageUrl().equals("https://demoqa.com/alertsWindows");
    }
}
