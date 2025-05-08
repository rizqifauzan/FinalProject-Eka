package stepDevinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class CartStepDef {
    CartPage cartPage = new CartPage();

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("user on the home page")
    public void userOnHomePage() {
        Assert.assertTrue(loginPage.isPageDisplayed());
    }

    @When("user input {string} as username")
    public void userInputUsername(String username) {
        loginPage.setInputUsername(username);
    }

    @When("user input {string} as password")
    public void userInputPassword(String password) {
        loginPage.setInputPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("user will redirect to home page")
    public void userRedirectToHomePage() {
        Assert.assertTrue(homePage.verifyPageIsDisplayed());
    }

    @Given("user is on the product page")
    public void userOnProductPage() {
        Assert.assertTrue(homePage.verifyPageIsDisplayed());
    }

    @When("user click image product")
    public void userClickImageProduct() {
        cartPage.clickFirstProductImage();
    }

    @And("user click Add to cart")
    public void userClickAddToCart() {
        cartPage.clickAddToCart();
    }

    @And("user click cart redirect to page cart")
    public void userClickCartToPageCart() {
        cartPage.goToCartPage();
    }

    @And("user click place order")
    public void userClickPlaceOrder() {
        cartPage.clickPlaceOrder();
    }

    @And("user input form check out for example data :")
    public void userInputCheckoutForm(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps().get(0);
        cartPage.inputCheckoutForm(
                data.get("name"),
                data.get("country"),
                data.get("city"),
                data.get("card"),
                data.get("month"),
                data.get("year")
        );
    }

    @And("user click Purchase")
    public void userClickPurchase() {
        cartPage.clickPurchase();
    }

    @Then("payment success and show notification “Thank you for your purchase!”")
    public void paymentSuccessMessage() {
        Assert.assertTrue(cartPage.isConfirmationDisplayed());
        Assert.assertEquals("Thank you for your purchase!", cartPage.getConfirmationText());
    }

    @And("user close pop up notification")
    public void closePopup() {
        cartPage.closePopup();
    }

    @When("user click delete")
    public void userClickDelete() {
        cartPage.deleteProductFromCart();
    }

    @Then("the product should be removed from the cart")
    public void verifyProductRemoved() {
        // You can add assertion based on cart state (e.g. check item count or message)
    }

    @Then("payment faild and show notification “Please fill out Name and Creditcard.”")
    public void paymentFailedMessage() {
        Assert.assertTrue(cartPage.isConfirmationDisplayed());
        Assert.assertEquals("Please fill out Name and Creditcard.", cartPage.getConfirmationText());
    }
}

