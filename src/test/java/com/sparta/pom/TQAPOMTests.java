package com.sparta.pom;

import com.sparta.pom.pages.ElementsPage;
import com.sparta.pom.pages.HomePage;
import com.sparta.pom.util.TQAUtil;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class TQAPOMTests {

    private static WebDriver webDriver;
    private HomePage homePage;
    private ElementsPage elementsPage;
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
        //chromeOptions.addArguments("headless");
        //webDriver = DriverFactory.getWebDriver("Chrome");
        webDriver = new ChromeDriver(service, chromeOptions);
        homePage = new HomePage(webDriver);
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

    }

    @Nested
    @DisplayName("Forms Page tests")
    class formsPageTests {
        @Test
        @DisplayName("matching Url on Forms Page")
        void matchingUrlOnFormsPage() {
            Assertions.assertEquals(true, homePage.goToFormPage().matchingURL());
        }
    }

    @AfterEach
    void teardown(){
        webDriver.close();
    }

    @AfterAll
    static void teardownAll(){
        service.stop();
        webDriver.quit();
    }

}
