package com.sparta.dw.cucumber.stepdefs;

import com.sparta.dw.pom.pages.ElementsPage;
import com.sparta.dw.pom.pages.HomePage;
import com.sparta.dw.pom.util.DriverFactory;
import com.sparta.dw.pom.util.TQAUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StepDefMatching {

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private HomePage homePage;
    private ElementsPage elementsPage;
    private WebDriver webDriver;
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
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1265,1380"); // this is the fix, only works for this one browser window size
        webDriver = DriverFactory.getWebDriver(DriverFactory.Browsers.CHROME, service, chromeOptions);
        homePage = new HomePage(webDriver);
        elementsPage = new ElementsPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


    }


//-----------------------------------------------------
// this was me trying to split up the function, doesn't hold onto the page across this
//-----------------------------------------------------

    @Given("I am on the Elements page")
    public void iAmOnTheElementsPage() {
        homePage.goToElementsPage();
    }

    @When("I click on the TextBox button")
    public void iClickOnTheTextBoxButton() {
       elementsPage.clickButton("item-0");
    }

    @And("I input text into the name box")
    public void iInputTextIntoTheNameBox() {
      elementsPage.inputText(elementsPage.getBoxID(ElementsPage.BoxId.USERNAME), "test");
    }

    @And("I press the submit button")
    public void iPressTheSubmitButton() {
        elementsPage.clickButton("submit");
    }

    @Then("The inputted name text should be output correctly")
    public void theInputtedNameTextShouldBeOutputCorrectly() {
        Assertions.assertEquals(true,elementsPage.compareResults(By.id("name"),"Name:test"));
    }


    @And("I input text into the email box")
    public void iInputTextIntoTheEmailBox() {
        elementsPage.inputText(elementsPage.getBoxID(ElementsPage.BoxId.USER_EMAIL), "test@test.com");
    }

    @Then("The inputted email text should be output correctly")
    public void theInputtedEmailTextShouldBeOutputCorrectly() {
        Assertions.assertEquals(true, elementsPage.compareResults(By.id("email"), "Email:test@test.com"));
    }

    @And("I input text into the Current Address box")
    public void iInputTextIntoTheCurrentAddressBox() {
        elementsPage.inputText(elementsPage.getBoxID(ElementsPage.BoxId.CURRENT_ADDRESS),"test");
    }

    @Then("The inputted Current Address text should be output correctly")
    public void theInputtedCurrentAddressTextShouldBeOutputCorrectly() {
        Assertions.assertEquals(true, elementsPage.compareResults(By.cssSelector(".border > #currentAddress"), "Current Address :test"));
    }

    @And("I input text into the Permanent Address box")
    public void iInputTextIntoThePermanentAddressBox() {
        elementsPage.inputText(elementsPage.getBoxID(ElementsPage.BoxId.PERMANENT_ADDRESS),"test");
    }

    @Then("The inputted Permanent Address text should be output correctly")
    public void theInputtedPermanentAddressTextShouldBeOutputCorrectly() {
        Assertions.assertNotEquals(true, elementsPage.compareResults(By.cssSelector(".border > #permanentAddress"), "Permanent Address :test"));
    }
    @After
    public void teardown(){
        webDriver.close();
        webDriver.quit();
    }
}
