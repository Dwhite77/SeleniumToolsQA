package com.sparta.dw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ElementsPage extends AbstractPage{

    public enum BoxId{
        USERNAME, USER_EMAIL, CURRENT_ADDRESS, PERMANENT_ADDRESS
    }

    public String getBoxID(BoxId id){
        switch (id) {
            case USER_EMAIL:
                return "userEmail";
            case USERNAME:
                return "userName";
            case CURRENT_ADDRESS:
                return "currentAddress";
            case PERMANENT_ADDRESS:
                return "permanentAddress";
            default:
                return "error no id selected";
        }
    }

    public ElementsPage(WebDriver webDriver) {
        setWebDriver(webDriver);


    }

    public boolean matchingURL(){
        return getPageUrl().equals("https://demoqa.com/elements");
    }


    public boolean matchingTextBoxName(String testInput){
        return matchingSuper("item-0",getBoxID(BoxId.USERNAME),testInput, By.id("name"), "Name:"+testInput );
    }

    public boolean matchingTextBoxEmail(){
        return matchingSuper("item-0",getBoxID(BoxId.USER_EMAIL),"test@test.com",  By.id("email"),"Email:test@test.com" );
    }


    public boolean matchingTextBoxAddress(){
        return matchingSuper("item-0",getBoxID(BoxId.CURRENT_ADDRESS),"test", By.cssSelector(".border > #currentAddress"),"Current Address :test" );
    }

    public boolean matchingTextBoxPermAddress(){
        return matchingSuper("item-0", getBoxID(BoxId.PERMANENT_ADDRESS), "test", By.cssSelector(".border > #permanentAddress"), "Permanent Address :test");
    }

    public boolean matchingSuper(String elementsBox, String boxId, String input,  By findResult, String compareResult){
        clickButton(elementsBox);
        inputText(boxId, input);
        clickButton("submit");
        return compareResults(findResult, compareResult);
    }


    //try these with returning elements page
    public void inputText(String boxId, String input){
        getWebDriver().findElement(By.id(boxId)).click();
        getWebDriver().findElement(By.id(boxId)).sendKeys(input);

    }

    public void clickButton(String buttonId){
        //new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.id(buttonId))).click();
        getWebDriver().findElement(By.id(buttonId)).click();


    }

    public boolean compareResults(By findResult, String compareResult){
        String result = getWebDriver().findElement(findResult).getText();
        return result.equals(compareResult);
    }

    private void implicitWait(int seconds){
        getWebDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }


}
