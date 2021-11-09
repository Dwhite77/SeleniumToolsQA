package com.sparta.dw.pom.pages;

import org.openqa.selenium.WebDriver;

public class BookStorePage extends AbstractPage{

    public BookStorePage(WebDriver webDriver) {
        setWebDriver(webDriver);
    }



    public boolean matchingURL(){
        return getPageUrl().equals("https://demoqa.com/books");
    }
}
