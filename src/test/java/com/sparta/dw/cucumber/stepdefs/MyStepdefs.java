package com.sparta.dw.cucumber.stepdefs;

import com.sparta.dw.pom.pages.*;
import com.sparta.dw.pom.util.DriverFactory;
import com.sparta.dw.pom.util.TQAUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class MyStepdefs {


    private HomePage homePage;
    private ElementsPage elementsPage;
    private FormsPage formsPage;
    private WebDriver webDriver;
    private AlertsPage alertsPage;
    private BookStorePage bookStorePage;
    private InteractionsPage interactionsPage;
    private WidgetsPage widgetsPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private static ChromeDriverService service;

    @Before
    public void initAll(){
        TQAUtil.setDriverLocation(DRIVER_LOCATION);
        service = TQAUtil.getChromeDriverService(DRIVER_LOCATION);
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--window-size=1265,1380");
        webDriver = DriverFactory.getWebDriver(DriverFactory.Browsers.CHROME,service, chromeOptions);
        homePage = new HomePage(webDriver);
    }


    @Given("I am on the toolsQA homepage")
    public void iAmOnTheToolsQAHomepage() {

    }

    @When("I click on the elements link")
    public void iClickOnTheElementsLink() {
        elementsPage = homePage.goToElementsPage();
    }

    @Then("I will go to the elements page")
    public void iWillGoToTheElementsPage() {
        Assertions.assertEquals(true, elementsPage.matchingURL());
    }

    @When("I click on the forms link")
    public void iClickOnTheFormsLink() {
        formsPage = homePage.goToFormsPage();
    }

    @Then("I will go to the forms page")
    public void iWillGoToTheFormsPage() {
        Assertions.assertEquals(true, formsPage.matchingURL());
    }


    @When("I click on the alerts link")
    public void iClickOnTheAlertsLink() {
        alertsPage = homePage.goToAlertsPage();
    }

    @Then("I will go to the alerts page")
    public void iWillGoToTheAlertsPage() {
        Assertions.assertEquals(true, alertsPage.matchingURL());
    }

    @When("I click on the BookStore link")
    public void iClickOnTheBookStoreLink() {
        bookStorePage = homePage.goToBookStorePage();
    }

    @Then("I will go to the BookStore page")
    public void iWillGoToTheBookStorePage() {
        Assertions.assertEquals(true, bookStorePage.matchingURL());
    }

    @When("I click on the interactions link")
    public void iClickOnTheInteractionsLink() {
        interactionsPage = homePage.goToInteractionsPage();
    }

    @Then("I will go to the interactions page")
    public void iWillGoToTheInteractionsPage() {
        Assertions.assertEquals(true, interactionsPage.matchingURL());
    }

    @When("I click on the Widgets link")
    public void iClickOnTheWidgetsLink() {
        widgetsPage = homePage.goToWidgetsPage();
    }

    @Then("I will go to the Widgets page")
    public void iWillGoToTheWidgetsPage() {
        Assertions.assertEquals(true, widgetsPage.matchingURL());
    }




    @After
    public void teardown(){
        webDriver.close();
        webDriver.quit();
    }


}
