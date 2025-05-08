package pages;

import org.openqa.selenium.WebDriver;

public class WebTestPage {
    WebDriver driver;

    public WebTestPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite() {
        driver.get("https://demoblaze.com/");
    }

    public boolean isWebsiteLoaded() {
        return driver.getTitle().contains("STORE");
    }
}
