package pages;


public class HomePageManager {
    //kullanılmadı
    public static void checkHomePageInitialized(HomePage homePage) {
        if (homePage == null) {
            throw new IllegalStateException(ErrorMessages.HOME_PAGE_NOT_INITIALIZED);
        }
    }
    //m Elementin mevcut olup olmadığını kontrol eden ve hata fırlatan metot
    public static void checkElementPresent(boolean isElementPresent, String elementKey) {
        if (!isElementPresent) {
            throw new AssertionError(String.format(ErrorMessages.ELEMENT_NOT_PRESENT, elementKey));
        }
    }
}
