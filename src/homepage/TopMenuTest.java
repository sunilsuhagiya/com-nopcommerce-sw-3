package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    // ********************** SELECT MENU **************************************//
    public void selectMenu(String menu){
        String mainMenu= menu.toLowerCase();
        String expression = "//a[@href ='/" + mainMenu + "']";
        driver.findElement(By.xpath(expression)).click();

    }

    @Test
    public void verifyPageNavigation(){
        mouseHoverToElementAndClick(By.xpath("//a[@href ='/computers']"));
        selectMenu("Computers");
        String expectedTextComputers = "Computers";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        //verify actual and expected message
        Assert.assertEquals(expectedTextComputers, actualText);

    }

    @After
    public void testDown() {
        closeBrowser();
    }
}