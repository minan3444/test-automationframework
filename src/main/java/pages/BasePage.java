package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.LocatorUtil;


public class BasePage {
    protected WebDriver driver;
    protected LocatorUtil locatorUtil;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.locatorUtil = new LocatorUtil();
    }
    //m
    protected WebElement findElement(String elementKey) {
        return driver.findElement(locatorUtil.getLocator(elementKey));
    }

    protected void clickElement(String elementKey) {
        findElement(elementKey).clear();
        findElement(elementKey).click();
    }
    //m
    protected void clickElementButtonBase(String elementKey) {
        findElement(elementKey).click();
    }
    //m
    protected void enterTextbase(String elementKey, String text) {
        findElement(elementKey).sendKeys(text);
    }
    protected void verifyElementbase(String elementKey) {
        findElement(elementKey);
    }

    protected String getElementText(String elementKey) {
        return findElement(elementKey).getText();
    }

    //m
    public boolean isElementPresent(String elementKey) {
        try {
            WebElement element = findElement(elementKey);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    // Not: Elementin üzerine gelme (hover) işlemi
    protected void hoverOverElement(String elementKey) {
        WebElement element = findElement(elementKey); // Elementi bulma
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();  // Mouse'u elementin üzerine getirme
    }

}
