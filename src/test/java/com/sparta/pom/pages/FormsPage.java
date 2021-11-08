package com.sparta.pom.pages;

import org.openqa.selenium.WebDriver;

public class FormsPage {

    private WebDriver webDriver;

    public FormsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getFormsPageUrl(){
        return webDriver.getCurrentUrl();
    }

    public boolean matchingURL(){
        return getFormsPageUrl().equals("https://demoqa.com/forms");
    }




}
