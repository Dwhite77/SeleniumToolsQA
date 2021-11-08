package com.sparta.pom.pages;

import org.openqa.selenium.WebDriver;

public class ElementsPage {
    private WebDriver webDriver;

    public ElementsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getElementsPageUrl(){
        return webDriver.getCurrentUrl();
    }

    public boolean matchingURL(){
        return getElementsPageUrl().equals("https://demoqa.com/elements");
    }

}
