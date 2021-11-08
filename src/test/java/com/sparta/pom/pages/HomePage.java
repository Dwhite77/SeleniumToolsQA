package com.sparta.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver webDriver;
    private By elementsCard = new By.ByCssSelector(".card:nth-child(1)");
    private By formsCard = new By.ByCssSelector(".card:nth-child(2)");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        goToHomePage();
    }

    public void goToHomePage(){
        webDriver.get("https://demoqa.com/");
    }

    public ElementsPage goToElementsPage(){
        webDriver.findElement(elementsCard).click();
        return new ElementsPage(webDriver);
    }

    public FormsPage goToFormPage(){
        webDriver.findElement(formsCard).click();
        return new FormsPage(webDriver);
    }

    public String getHomePageURL(){
        return webDriver.getCurrentUrl();
    }
}

