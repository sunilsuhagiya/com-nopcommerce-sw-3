package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        //1.1 Mouse Hover on “Electronics”Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //1.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals(expectedMessage, actualMessage);


    }

   @Test
   public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse Hover on “Electronics” Tab
       mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

     //2.2 Mouse Hover on “Cell phones” and click
       mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

       //2.3 Verify the text “Cell phones”
       String expectedMessage = "Cell phones";
       String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
       Assert.assertEquals(expectedMessage, actualMessage);

       //2.4 Click on List View Tab
       clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(3000);
       //2.5 Click on product name “Nokia Lumia 1020” link
       clickOnElement(By.linkText("Nokia Lumia 1020"));

       //2.6 Verify the text “Nokia Lumia 1020”
       String expectedMessage1 = "Nokia Lumia 1020";
       String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
       Assert.assertEquals(expectedMessage, actualMessage);

       //2.7 Verify the price “$349.00”
       String expectedMessage2 = " $349.00 ";
       String actualMessage2 = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
       Assert.assertEquals(expectedMessage, actualMessage);

       //2.8 Change quantity to 2
       driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
       sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

     //2.9 Click on “ADD TO CART” tab
       clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

     //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
       String expectedMessage3 = "The product has been added to your shopping cart";
       String actualMessage3 = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
       Assert.assertEquals(expectedMessage, actualMessage);

     //After that close the bar clicking on the cross button.
       clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

     //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
       mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));
       clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
     //2.12 Verify the message "Shopping cart"
       String expectedMessage4 = "Shopping cart";
       String actualMessage4 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
       Assert.assertEquals(expectedMessage, actualMessage);
     //2.13 Verify the quantity is 2
       String expectedMessage5 = "2";
       String actualMessage5 = getTextFromElement(By.xpath("//th[contains(text(),'Qty.')]"));
       Assert.assertEquals(expectedMessage, actualMessage);
     //2.14 Verify the Total $698.00
       String expectedMessage6 = "$698.00";
       String actualMessage6 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
       Assert.assertEquals(expectedMessage, actualMessage);
     //2.15 click on checkbox “I agree with the terms of service”
       clickOnElement(By.xpath("//input[@id='termsofservice']"));
     //2.16 Click on “CHECKOUT”
       clickOnElement(By.id("checkout"));
     //2.17 Verify the Text “Welcome, Please Sign In!”
       String expectedMessage7 = "Welcome, Please Sign In!";
       String actualMessage7 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
       Assert.assertEquals(expectedMessage, actualMessage);
     //2.18 Click on “REGISTER” tab
       clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
     //2.19 Verify the text “Register”
       String expectedMessage8 = "Register";
       String actualMessage8 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
       Assert.assertEquals(expectedMessage, actualMessage);
      //2.20 Fill the mandatory fields
       //Select gender radio button
       clickOnElement(By.id("gender-male"));
       //Send text to FirstName
       sendTextToElement(By.id("FirstName"),"Prime");
       //Send text to LastName
       sendTextToElement(By.id("LastName"),"Test");
       // Select Day Month and Year
       sendTextToElement(By.name("DateOfBirthDay"),"5");
       sendTextToElement(By.name("DateOfBirthMonth"),"5");
       sendTextToElement(By.name("DateOfBirthYear"),"1926");
       // Sending email id to Email field
       sendTextToElement(By.name("Email"),"TP3@gmail.com");
       // Sending password for password field
       sendTextToElement(By.name("Password"),"123demo");
       // sending confirm password for confirm password field
       sendTextToElement(By.name("ConfirmPassword"),"123demo");

       //2.21 Click on “REGISTER” Button
       clickOnElement(By.id("register-button"));

       //2.22 Verify the message “Your registration completed”
       String expectedMessage10 = "Your registration completed";
       String actualMessage10 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));

       //2.23 Click on “CONTINUE” tab
       clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
     //2.24 Verify the text “Shopping card”
       String expectedMessage9 = "Shopping cart";
       String actualMessage9 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
       Assert.assertEquals(expectedMessage, actualMessage);
     //2.25 click on checkbox “I agree with the terms of service”
       clickOnElement(By.id("termsofservice"));
     //2.26 Click on “CHECKOUT”
       clickOnElement(By.id("checkout"));
     //2.27 Fill the Mandatory fields
       sendTextToElement(By.id("BillingNewAddress_FirstName"),"dgjk");
       sendTextToElement(By.id("BillingNewAddress_LastName"),"tre");
       //sendTextToElement(By.id("BillingNewAddress_Email"),"abc@gmail.com");
       selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
       selectByVisibleTextFromDropDown(By.id("BillingNewAddress_StateProvinceId"),"Florida");
       sendTextToElement(By.id("BillingNewAddress_City"),"Atlanta");
       sendTextToElement(By.id("BillingNewAddress_Address1"),"xyz street");
       sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"4852");
       sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"9852693321");

     //2.28 Click on “CONTINUE”
       clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
     //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
     //2.30 Click on “CONTINUE”
       clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
     //2.31 Select Radio Button “Credit Card”
       clickOnElement(By.id("paymentmethod_1"));
       Thread.sleep(3000);
       clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
    //2.32 Select “Visa” From Select credit card dropdown
       selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Visa");
     //2.33 Fill all the details
       sendTextToElement(By.id("CardholderName"),"abc");
       sendTextToElement(By.id("CardNumber"),"5555555555554444");
       selectTheOptionByValue(By.xpath("//select[@id='ExpireMonth']"), "2");
       selectTheOptionByValue(By.xpath("//select[@id='ExpireYear']"), "2023");
       sendTextToElement(By.xpath("//input[@id='CardCode']"), "469");
       Thread.sleep(3000);
     //2.34 Click on “CONTINUE”
       clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
     //2.35 Verify “Payment Method” is “Credit Card”
       Thread.sleep(3000);
       String expectedPaymentMethod = "Payment Method: Credit Card";
       String actualPaymentMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]"));
       Assert.assertEquals(expectedPaymentMethod, actualPaymentMethod);
     //2.36 Verify “Shipping Method” is “2nd Day Air”
       String expectedShippingMethod = "Shipping Method: 2nd Day Air";
       String actualShippingMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));
       Assert.assertEquals("Shipping Method is not correct", expectedShippingMethod, actualShippingMethod);
     //2.37 Verify Total is “$698.00”
       String expectedFinalTotal = "$698.00";
       String actualFinalTotal = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
       Assert.assertEquals("Final Total is not correct", expectedFinalTotal, actualFinalTotal);
     //2.38 Click on “CONFIRM”
       clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
     //2.39 Verify the Text “Thank You”
       String expectedText = "Thank you";
       String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
       Assert.assertEquals("Thank You does not display", expectedText, actualText);
     //2.40 Verify the message “Your order has been successfully processed!”
       String expectedText2 = "Your order has been successfully processed!";
       String actualText2 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
       Assert.assertEquals("Payment error", expectedText2, actualText2);
     //2.41 Click on “CONTINUE”
       clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
     //2.42 Verify the text “Welcome to our store”
       Thread.sleep(3000);
       String expectedWelcome = "Welcome to our store";
       String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
       Assert.assertEquals("Welcome to our store not displayed", expectedWelcome, actualWelcome);
     //2.43 Click on “Logout” link
       clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
     //2.44 Verify the URL is “https://demo.nopcommerce.com/”
      driver.getCurrentUrl();


   }


}
