package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

public class HomePage extends BasePage {
    private BasePage basePage;

    //m
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void verifyElement(String elementKey) {
        verifyElementbase(elementKey);
    }


    //m
    public void enterText(String elementKey, String text) {
        enterTextbase(elementKey,text);
    }


    //m
    public void clickElement(String elementKey) {
        super.clickElement(elementKey);  // BasePage'deki protected clickElement metodunu çağırır
    }
    //m
    public void enterTextIntoElement(String elementKey, String text) {
        enterText(elementKey, text); // BasePage'deki protected metodu çağırır.
    }

    //m
    public void clickElementButtonHomePage(String elementKey) {
        clickElementButtonBase(elementKey); // BasePage'deki protected metodu çağırır.
    }

    // Not: Dropdown seçeneğini seçme
    public void selectDropdownOption(String option, String elementKey) {
        super.findElement(elementKey).sendKeys(option);  // Dropdown'da seçeneği seçer
    }

    // Not: Mouse ile elementin üzerine gelme işlemi
    public void hoverOverElementByKey(String elementKey) {
    hoverOverElement(elementKey);
    }

}
