package com.sparta.dw.pom.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

    private WebDriver webDriver;

    private Object page;

    public String getPageUrl(){
        return webDriver.getCurrentUrl();
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public Object getPage() {
        return page;
    }
    public void setPage(Object page){
        this.page = page;
    }
}
