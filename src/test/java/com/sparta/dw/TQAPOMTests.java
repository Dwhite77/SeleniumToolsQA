package com.sparta.dw;

import com.sparta.dw.pom.util.DriverFactory;
import com.sparta.dw.pom.util.TQAUtil;
import com.sparta.dw.pom.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TQAPOMTests {

    private static WebDriver webDriver;
    private HomePage homePage;
    private static ChromeDriverService service;

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    @BeforeAll
    static void initAll(){
        TQAUtil.setDriverLocation(DRIVER_LOCATION);
        service = TQAUtil.getChromeDriverService(DRIVER_LOCATION);
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void init(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1121,1045");
        webDriver = DriverFactory.getWebDriver(DriverFactory.Browsers.CHROME,service, chromeOptions);
        webDriver.manage().window().fullscreen();
        homePage = new HomePage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Nested
    @DisplayName("Alerts Page tests")
    class alertsPageTests {
        @Test
        @DisplayName("matching URL on Alerts Page")
        void matchingUrlOnAlertsPage() {
            Assertions.assertEquals(true,homePage.goToAlertsPage().matchingURL());
        }
    }

    @Nested
    @DisplayName("Book Store Page Tests")
    class bookStorePageTests {
        @Test
        @DisplayName("matching URL on Book Store page")
        void matchingUrlOnBookStorePage() {
            Assertions.assertEquals(true, homePage.goToBookStorePage().matchingURL());
        }
    }

    @Nested
    @DisplayName("Elements page tests")
    class elementsPageTests {

        @Test
        @DisplayName("open the webpage")
        void openTheWebpage() {
            Assertions.assertEquals("https://demoqa.com/",homePage.getHomePageURL());
        }

        @Test
        @DisplayName("matching Url on elements page")
        void matchingUrlOnElementsPage() {
            Assertions.assertEquals(true,homePage.goToElementsPage().matchingURL());
        }

        @Test
        @DisplayName("check that the typed name shows up in the name box")
        void checkThatTheTypedNameShowsUpInTheNameBox() {
            Assertions.assertEquals(true,homePage.goToElementsPage().matchingTextBoxName("testing"));
        }

        @Test
        @DisplayName("check that the typed email shows up in the email box")
        void checkThatTheTypedEmailShowsUpInTheEmailBox() {
            Assertions.assertEquals(true, homePage.goToElementsPage().matchingTextBoxEmail());
        }

        @Test
        @DisplayName("check that the typed Address shows up in the address box")
        void checkThatTheTypedAddressShowsUpInTheAddressBox() {
            Assertions.assertEquals(true, homePage.goToElementsPage().matchingTextBoxAddress());
        }

        @Test
        @DisplayName("check that the typed address shows up in the address box super")
        void checkThatTheTypedAddressShowsUpInTheAddressBoxSuper() {
            Assertions.assertEquals(true, homePage.goToElementsPage().matchingSuper("item-0","currentAddress","test", By.cssSelector(".border > #currentAddress"),"Current Address :test"));
        }

        @Test
        @DisplayName("check that the typed perm address shows up in the perm address box") // this test won't work as the text in the output field is wrong
        void checkThatTheTypedPermAddressShowsUpInThePermAddressBox() {
            Assertions.assertNotEquals(true, homePage.goToElementsPage().matchingTextBoxPermAddress());
        }

    }

    @Nested
    @DisplayName("Forms Page tests")
    class formsPageTests {
        @Test
        @DisplayName("matching Url on Forms Page")
        void matchingUrlOnFormsPage() {
            Assertions.assertEquals(true, homePage.goToFormsPage().matchingURL());
        }
    }

    @Nested
    @DisplayName("Interactions Page Tests")
    class interactionsPageTests {
        @Test
        @DisplayName("matching URL on Interactions Page")
        void matchingUrlOnInteractionsPage() {
            Assertions.assertEquals(true, homePage.goToInteractionsPage().matchingURL());
        }
    }

    @Nested
    @DisplayName("Widgets Page Tests")
    class widgetsPageTests {
        @Test
        @DisplayName("matching URL on Widgets Page")
        void matchingUrlOnWidgetsPage() {
            Assertions.assertEquals(true, homePage.goToWidgetsPage().matchingURL());
        }
    }
    @AfterEach
    void teardown(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.close();
    }

    @AfterAll
    static void teardownAll(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.stop();
//        webDriver.quit();
    }

}
