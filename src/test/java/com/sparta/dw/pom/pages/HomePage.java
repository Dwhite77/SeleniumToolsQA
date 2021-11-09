package com.sparta.dw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver webDriver;
    private final By elementsCard = new By.ByCssSelector(".card:nth-child(1)");
    private final By formsCard = new By.ByCssSelector(".card:nth-child(2)");
    private final By alertsCard = new By.ByCssSelector(".card:nth-child(3)");
    private final By widgetsCard = new By.ByCssSelector(".card:nth-child(4)");
    private final By interactionsCard = new By.ByCssSelector(".card:nth-child(5)");
    private final By bookStoreCard = new By.ByCssSelector(".card:nth-child(6)");

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

    public FormsPage goToFormsPage(){
        webDriver.findElement(formsCard).click();
        return new FormsPage(webDriver);
    }

    public AlertsPage goToAlertsPage(){
        webDriver.findElement(alertsCard).click();
        return new AlertsPage(webDriver);
    }

    public WidgetsPage goToWidgetsPage(){
        webDriver.findElement(widgetsCard).click();
        return new WidgetsPage(webDriver);
    }

    public InteractionsPage goToInteractionsPage(){
        webDriver.findElement(interactionsCard).click();
        return new InteractionsPage(webDriver);
    }

    public BookStorePage goToBookStorePage(){
        webDriver.findElement(bookStoreCard).click();
        return new BookStorePage(webDriver);
    }


    public String getHomePageURL(){
        return webDriver.getCurrentUrl();
    }
}

