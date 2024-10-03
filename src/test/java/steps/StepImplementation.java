package steps;
import com.thoughtworks.gauge.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomePageManager;
import utils.Browser;
import pages.HomePage;
import org.openqa.selenium.WebDriver;

public class StepImplementation {
    //webdriver türünde driver,Browser türünde browser,HomePage türünde homepage diye değişken tanımlandı.
    // Ancak, bu değişkenler başlangıçta yani şuanda null değerindedir.
    private WebDriver driver;
    private Browser browser;
    private HomePage homePage;
    private HomePageManager homePageManager;

    //StepImplementation sınıfından bir nesne oluşturulduğunda, buradaki constructor otomatik olarak çağrılır.
    //Artık browser değişkeni, yeni oluşturulmuş bir Browser nesnesini referans alır, null değil.
    public StepImplementation() {
        browser = new Browser();
        //driver ve homePage gibi değişkenlerin başlatılması,genellikle test adımlarına bağlı olarak dinamik
        // bir süreçtir.Constructorda bu işlemleri yapmak yerine,test adımları içinde ihtiyaç duyulduğunda
        // başlatmak daha uygundur.
    }


    //m
    @Step("Open <browserType> browser with notifications disabled")
    public void openBrowserWithNotificationsDisabled(String browserType) {
        driver = browser.getDriver(browserType, true);//driver değişkenine bu dönen WebDriver nesnesi atanır.
        // Yani, driver artık bu WebDriver nesnesini referans alır,null değildir.
     homePage = new HomePage(driver);
    }

    //m
    @Step("Navigate to <url>")
    public void navigateTo(String url) {
        driver.get(url);
    }

    //m
    @Step("Click on element <elementKey>")
    public void clickOnElement(String elementKey) {
        homePage.clickElementButtonHomePage(elementKey);
    }
    //m
    @Step("Verify element <elementKey> is present")
    public void verifyElementIsPresent(String elementKey) {
        boolean isElementPresent = homePage.isElementPresent(elementKey); // Doğru metod çağrısı yapıldı
        HomePageManager.checkElementPresent(isElementPresent, elementKey);
    }

    //m
    @Step("Verify element <elementKey> is present and click")
    public void verifyElementIsPresentAndClick(String elementKey) {
       // boolean isElementPresent = homePage.isElementPresent(elementKey); // Doğru metod çağrısı yapıldı
        homePage.clickElementButtonHomePage(elementKey);
    }
    //m
    @Step("Enter text <laptop> into <searchBox>")
    public void implementation1(String text, String elementKey) {
        homePage.enterText(elementKey, text);
    }


//    //ok
//    @Step("Click element <elementKey>")
//    public void clickElement(String elementKey) {
//        if (elementKey.equals("searchButton")) {
//            homePage.clickSearchButton();
//        } else {
//            throw new IllegalArgumentException("Invalid element key: " + elementKey);
//        }
//    }

    //m commentout yapılacak azure pipeline çalıştırıldıktan sonra
//    @Step("Enter text <text> into <elementKey> and click <elementKey>")
//    public void enterTextAndClickButton(String text, String elementKey, String buttonKey) {
//        homePage.enterTextIntoElement(elementKey, text); // Yeni metot çağrılıyor.
//        homePage.clickElementButtonHomePage(buttonKey); // Yeni metot çağrılıyor.
//    }
    //commentout yapılacak azure pipeline çalıştırıldıktan sonra
//    @Step("Select dropdown option <option> from <elementKey>")
//    public void selectDropdownOption(String option, String elementKey) {
//        homePage.selectDropdownOption(option, elementKey);
//    }
    @Step("Hover over element <<elementKey>")
    public void hoverOnElement(String elementKey) {
        homePage.hoverOverElementByKey(elementKey); // BasePage'deki hover fonksiyonunu kullan
    }

    @Step("Wait for <seconds> seconds")
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Bekleme süresini milisaniyeye çevirir
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
