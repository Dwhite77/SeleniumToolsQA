package com.sparta.pom.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

    private WebDriver webDriver;

    public String getPageUrl(){
        return webDriver.getCurrentUrl();
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }


}
