package utils;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class LocatorUtil {
    private JSONObject jsonObject;
    private Map<String, By> locators;

    public LocatorUtil() {
        locators = new HashMap<>();
        loadJSON();
        parseLocators();
    }

    private void loadJSON() {
        // JSON dosyasının bulunduğu yolu doğru belirtin
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("elements.json");
        if (inputStream == null) {
            throw new IllegalStateException("JSON file 'elements.json' not found in resources.");
        }
        JSONTokener tokener = new JSONTokener(inputStream);
        jsonObject = new JSONObject(tokener);
    }

    private void parseLocators() {
        jsonObject.keys().forEachRemaining(key -> {
            JSONObject locatorData = jsonObject.getJSONObject(key);
            String type = locatorData.getString("type");
            String value = locatorData.getString("value");

            switch (type) {
                case "id":
                    locators.put(key, By.id(value));
                    break;
                case "name":
                    locators.put(key, By.name(value));
                    break;
                case "xpath":
                    locators.put(key, By.xpath(value));
                    break;
                case "css":
                    locators.put(key, By.cssSelector(value));
                    break;
                case "className":
                    locators.put(key, By.className(value));
                    break;
                case "tagName":
                    locators.put(key, By.tagName(value));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid locator type: " + type);
            }
        });
    }

    public By getLocator(String key) {
        return locators.get(key);
    }
}
