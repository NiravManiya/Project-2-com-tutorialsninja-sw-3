package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElement(By.xpath("//a[text()='Laptops & Notebooks']"));

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[text()='Laptops & Notebooks']"));

        //1.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));

        //1.4 Verify the Product price will arrange in High to Low order.
        assertionMethod("Displayed are not arranged by High to Low", "Price (High > Low)", By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC']"));
    }

    private void assertionMethod(String s, String s1, By xpath) {

    }

    private void mouseHoverToElement(By xpath) {

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        //Select Sort By "Price (High > Low)"
        selectByValueFromDropDown(By.id("input-sort"), "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");

        //Select Product “Sony VAIO”
        clickOnElement(By.linkText("Sony VAIO"));

        //Verify the text “Sony VAIO”
        Assert.assertEquals("Sony VAIO", getTextFromElement(By.xpath("//h1[contains(text(),'Sony VAIO')]")));

        //Click on ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));

        //Verify the message “Success: You have added Sony VAIO to your shopping cart!”
        Assert.assertEquals("Success: You have added Sony VAIO to your shopping cart!", getTextFromElement(By.xpath("//div[contains(text(),'Success')]")).substring(0, 56));

        //Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("shopping cart"));

        //Verify the text "Shopping Cart"
        Assert.assertEquals("Shopping Cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).substring(0, 13));

        //Verify the Product name "Sony VAIO"
        Assert.assertEquals("Sony VAIO", getTextFromElement(By.linkText("Sony VAIO")));

        //Change Quantity "2"
        driver.findElement(By.xpath("//input[@class='form-control']")).clear();
        sendTextToElement(By.xpath("//input[@class='form-control']"), "2");

        //Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));

        //Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals("Success: You have modified your shopping cart!", getTextFromElement(By.xpath("//div[contains(text(),'Success')]")).substring(0, 46));

        //Verify the Total £737.45
        Assert.assertEquals("£1,472.45", getTextFromElement(By.xpath("//tbody//tr//td[6]")));

        //Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //Verify the text “Checkout”
        Assert.assertEquals("Checkout", getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']")));

        //Verify the Text “New Customer”
        Assert.assertEquals("New Customer", getTextFromElement(By.xpath("//h2[normalize-space()='New Customer']")));

        //Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));

        //Click on “Continue” tab
        clickOnElement(By.id("button-account"));

        //Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "Kartik");
        sendTextToElement(By.id("input-payment-lastname"), "Shah");
        sendTextToElement(By.id("input-payment-email"), "imthebest@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "1234567890");
        sendTextToElement(By.id("input-payment-address-1"), "60 waterhouse eet");
        sendTextToElement(By.id("input-payment-city"), "Milton keynes");
        sendTextToElement(By.id("input-payment-postcode"), "kt25eg");
        //selectByValueFromDropDown(By.id("input-payment-country"), "212");
        selectByValueFromDropDown(By.id("input-payment-zone"), "3004");

        //Click on “Continue” Button
        clickOnElement(By.id("button-guest"));

        //Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "I want a macbook");

        //Click on “Continue” button
        clickOnElement(By.id("button-shipping-method"));

        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.id("button-payment-method"));

        //Verify the message “Warning: Payment method required!”
        clickOnElement(By.id("button-confirm"));  }

    private void mouseHoverToElementAndClick(By xpath) {

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
