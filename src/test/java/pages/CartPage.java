package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCartButton = By.linkText("Add to cart");
    By cartLink = By.id("cartur");
    By placeOrderButton = By.xpath("//button[text()='Place Order']");
    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By cardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By purchaseButton = By.xpath("//button[text()='Purchase']");
    By closePopupButton = By.xpath("//button[text()='OK']");
    By deleteButton = By.linkText("Delete");
    By confirmationMessage = By.className("sweet-alert");

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void clickCartLink() {
        driver.findElement(cartLink).click();
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public void fillCheckoutForm(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }

    public void clickPurchase() {
        driver.findElement(purchaseButton).click();
    }

    public void closePopup() {
        driver.findElement(closePopupButton).click();
    }

    public String getConfirmationMessage() {
        WebElement popup = driver.findElement(confirmationMessage);
        return popup.getText();
    }

    public void deleteProduct() {
        driver.findElement(deleteButton).click();
    }
}
