package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ==== Header ====
    By logo = By.id("nava");
    By homeLink = By.xpath("//a[text()='Home ']");
    By contactLink = By.xpath("//a[text()='Contact']");
    By aboutUsLink = By.xpath("//a[text()='About us']");
    By cartLink = By.id("cartur");
    By loginLink = By.id("login2");
    By signupLink = By.id("signin2");
    By logoutLink = By.id("logout2");
    By welcomeText = By.id("nameofuser");

    // ==== Categories ====
    By categoryPhones = By.xpath("//a[text()='Phones']");
    By categoryLaptops = By.xpath("//a[text()='Laptops']");
    By categoryMonitors = By.xpath("//a[text()='Monitors']");

    // ==== Product Section ====
    By productCards = By.className("card");
    By productTitles = By.className("card-title");
    By productPrices = By.className("card-block");
    By nextButton = By.id("next2");
    By previousButton = By.id("prev2");

    // ==== Footer ====
    By aboutUsText = By.xpath("//h5[text()='About Us']/following-sibling::p");
    By addressText = By.xpath("//h5[text()='Get in Touch']/following-sibling::p[1]");
    By phoneText = By.xpath("//h5[text()='Get in Touch']/following-sibling::p[2]");
    By emailText = By.xpath("//h5[text()='Get in Touch']/following-sibling::p[3]");

    // ==== Actions ====

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickSignup() {
        driver.findElement(signupLink).click();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

    public void clickCart() {
        driver.findElement(cartLink).click();
    }

    public void clickHome() {
        driver.findElement(homeLink).click();
    }

    public void clickContact() {
        driver.findElement(contactLink).click();
    }

    public void clickAboutUs() {
        driver.findElement(aboutUsLink).click();
    }

    public void clickCategory(String category) {
        driver.findElement(By.xpath("//a[@id='itemc' and text()='" + category + "']")).click();
    }

    public List<WebElement> getProductTitles() {
        return driver.findElements(productTitles);
    }

    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    public void clickPrevious() {
        driver.findElement(previousButton).click();
    }

    public String getWelcomeText() {
        return driver.findElement(welcomeText).getText();
    }

    public String getFooterAboutUs() {
        return driver.findElement(aboutUsText).getText();
    }

    public String getFooterAddress() {
        return driver.findElement(addressText).getText();
    }

    public String getFooterPhone() {
        return driver.findElement(phoneText).getText();
    }

    public String getFooterEmail() {
        return driver.findElement(emailText).getText();
    }

    public boolean verifyPageIsDisplayed() {
        return isLogoDisplayed() && driver.getTitle().contains("STORE");
    }
}
