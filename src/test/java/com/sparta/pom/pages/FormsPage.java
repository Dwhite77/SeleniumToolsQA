package com.sparta.pom.pages;

import org.openqa.selenium.WebDriver;

public class FormsPage extends AbstractPage{



    public FormsPage(WebDriver webDriver) {
        setWebDriver(webDriver);
    }



    public boolean matchingURL(){
        return getPageUrl().equals("https://demoqa.com/forms");
    }




}
