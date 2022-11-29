package utilities;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();

    }
    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        WebElement emailField = driver.findElement(by);
        emailField.sendKeys(text);

    }
    /**
     * This method will send text to element
     */

    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public void sendTextElementPassword(By by, String text) {

        WebElement passwordField = driver.findElement(by);
        passwordField.sendKeys(text);
    }

    //************************************Alert Methods***********************************//
    // Switch to alert method
    public void switchToAlert() {
        driver.switchTo().alert();

    }
    // Accept alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // Dismiss Alert method
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // String getTextFromAlert
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    // Send text to Alert
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    // Homework 4 Method (acceptAlert,dismissAlert, )acceptAlert,dismissAlert,  String getTextFromAlert, sendTextToAlert(String text)

// ***************** Select Class Methods **************************

    // utility class method This method will select option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        // Create object of select class
        Select select = new Select(dropDown);
        // Select by text
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */

    public void selectTheOptionByValue(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create object of select class
        Select select = new Select(dropDown);
        // Select by value
        select.selectByValue(value);
    }

    /**
     * This method will select the option by index
     */
    public void selectTheOptionByIndex(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        // Create object of select class by index
        Select select = new Select(dropDown);
        // Select by value by index
        select.selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */
    public void selectOptionByContainsText(By by, String containText) {
        WebElement dropDown = driver.findElement(by);
        // Create object of select class option
        Select select = new Select(dropDown);
        // Select by option
        select.getFirstSelectedOption();
    }

// ***************** Window Handle **************************

// ***************** Action Class **************************

    /**
     * This method will mouse hover to element
     */
    public void mouseHoverToElement(By by) {
        WebElement mouseHover = driver.findElement(by);
        // Creating object of an Action class
        Actions action = new Actions(driver);
        // Performing action using move to element method using mouse
        action.moveToElement(mouseHover).build().perform();

    }
    /**
     * This method will mouse hover to element and click method
     */
    public void mouseHoverToElementAndClick(By by) {

        WebElement mouseHover = driver.findElement(by);
        // Creating object of an Action class
        Actions action = new Actions(driver);
        // Performing action using move to element method using mouse
        action.moveToElement(mouseHover).click().build().perform();

    }
//************************************ Assert Equals ***********************************//
    /**
     * This method will Verify Message
     */
    public void verifyMessage(String expectedMessage, String actualMessage){
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
