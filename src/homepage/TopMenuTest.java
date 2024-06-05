package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");

        //1.3 Verify the text ‘Desktops’
        WebElement sortByElement = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(sortByElement);
        select.selectByVisibleText("Name (Z - A)");
    }

    private void mouseHoverToElementAndClick(By xpath) {

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.linkText("Laptops & Notebooks"));

        //* 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        WebElement sortByElement = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(sortByElement);
        select.selectByVisibleText("Name (A - Z)");

    }

    private void selectMenu(String s) {

    }

    @After
    public void tearDown() {

    }
}
