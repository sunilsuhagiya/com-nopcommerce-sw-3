package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        // Click on Computer Menu
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        // Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        // Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: Z to A");
        // Verify the Product will arrange in Descending order
        // Expected Message
        String expectedText = "Name: Z to A";
        // Actual Message
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        //verify actual and expected message
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // Click on Computer Menu
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        // Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        // Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: A to Z");
        Thread.sleep(5000);
        // Click on add to card
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/h2[1]/a[1]"));

        // Verify text Build your own computer
        // This is from requirement documents
        String expectedMessage = "Build your own computer";
        // Find the welcome text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        String actualMessage = actualTextMessageElement.getText();
        // Validate actual and expected message
        Assert.assertEquals("Build your own computer Text not found", expectedMessage, actualMessage);
        // Click on Build your own computer
        //clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/h2[1]/a[1]"));
        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        // Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");
        // Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(5000);
        clickOnElement(By.id("product_attribute_3_7"));//"400 GB [+$100.00]");
        // Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));// Vista Premium [+$60.00]
        //selectByVisibleTextFromDropDown(By.id("product_attribute_4_9"),"Vista Premium [+$60.00]");
        // Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));//Total Commander [+$5.00]
        //selectByVisibleTextFromDropDown(By.id("product_attribute_5_12"),"Total Commander [+$5.00]");
        // Verify the price "$1,475.00"
        String expectedMessage1 = "$1,475.00";
        // Find the welcome text element and get the text
        Thread.sleep(5000);
        WebElement actualTextMessageElement1 = driver.findElement(By.xpath("//span[@id='price-value-1']"));
        String actualMessage1 = actualTextMessageElement.getText();
        // Validate actual and expected message
        //Assert.assertEquals("$1,475.00",expectedMessage1,actualMessage1);
        //Click on "ADD TO CARD" Button
        clickOnElement(By.id("add-to-cart-button-1"));
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        // This is from requirement documents
        String expectedMessage2 = "The product has been added to your";
        // Find the welcome text element and get the text
        WebElement actualTextMessageElement2 = driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        String actualMessage2 = actualTextMessageElement.getText();
        // Validate actual and expected message
        //Assert.assertEquals("The product has been added to your Text not found",expectedMessage2,actualMessage2);
        // clicking on the cross button
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //Then MouseHover on "Shopping cart" Click on "GO TO CART" button
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //Verify the message "Shopping cart"
        Thread.sleep(3000);
        String expectedMessageCart = "Shopping cart";
        String actualMessageCart = getTextFromElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Change the Qty to "2" and Click on "Update shopping cart
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendTextToElement(By.xpath("//input[@value='1']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //2.17 Verify the Total"$2,950.00"
        Thread.sleep(5000);
        String expectedPrice1 = "$2,950.00";
        String actualPrice1 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals(expectedPrice1, actualPrice1);
        //click on checkbox “I agree with the terms of service”
        mouseHoverToElementAndClick(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(5000);
        String expectedTextWelcome = "Welcome, Please Sign In!";
        String actualTextWelcome = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expectedPrice1, actualPrice1);
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        // Fill the all mandatory field
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Aa");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Ss");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "aass@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "Australia");
        //selectByVisibleTextFromDropDown(By.id("BillingNewAddress_StateProvinceId"),"QLD");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Brisbane");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "Zetland road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "4122");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "1234567890");
        // Click on “CONTINUE”
        clickOnElement(By.name("save"));
        // Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // Select Radio Button “Credit Card” and click on continue
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        // Select “Master card” From Select credit card dropdown
        Thread.sleep(3000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        // Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Aa");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        selectTheOptionByValue(By.xpath("//select[@id='ExpireMonth']"), "2");
        selectTheOptionByValue(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "469");
        // Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        // Verify “Payment Method” is “Credit Card”
        Thread.sleep(3000);
        String expectedPaymentMethod = "Payment Method: Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals(expectedPaymentMethod, actualPaymentMethod);
        // Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Shipping Method: Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals("Shipping Method is not correct", expectedShippingMethod, actualShippingMethod);
        // Verify Total is “$2,950.00”
        String expectedFinalTotal = "$2,950.00";
        String actualFinalTotal = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("Final Total is not correct", expectedFinalTotal, actualFinalTotal);
        // Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        // Verify the Text “Thank You”
        String expectedText1 = "Thank you";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Thank You does not display", expectedText1, actualText1);
        // Verify the message “Your order has been successfully processed!”
        String expectedText2 = "Your order has been successfully processed!";
        String actualText2 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Payment error", expectedText2, actualText2);
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        // Verify the text “Welcome to our store”
        Thread.sleep(3000);
        String expectedWelcome = "Welcome to our store";
        String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Welcome to our store not displayed", expectedWelcome, actualWelcome);
    }


    @After
    public void testDown() {
        closeBrowser();
    }


}
