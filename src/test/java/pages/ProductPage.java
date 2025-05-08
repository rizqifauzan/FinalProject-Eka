package pages;

import org.openqa.selenium.By;
import static helper.Utility.webDriver;

public class ProductPage {

    By iconShoppingCart = By.id("shopping_cart_container");
    By firstProductAddToCartButton = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    By removeButtonForFirstProduct = By.xpath("(//button[contains(text(),'Remove')])[1]");

    // verifikasi bahwa icon cart ditampilkan
    public boolean verifyPageIsDisplayed() {
        return webDriver.findElement(iconShoppingCart).isDisplayed();
    }

    // klik add to cart untuk produk pertama
    public void addFirstProductToCart() {
        webDriver.findElement(firstProductAddToCartButton).click();
    }

    // klik remove untuk produk pertama di cart
    public void removeFirstProductFromCart() {
        webDriver.findElement(removeButtonForFirstProduct).click();
    }

    // cek produk
    public boolean isProductInCart() {
        try {
            return webDriver.findElement(removeButtonForFirstProduct).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}