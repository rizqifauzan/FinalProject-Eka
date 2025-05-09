package stepDevinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginStepDef {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("user open the home page Demoblaze")
    public void openHomePage() {
        driver.get("https://demoblaze.com/");
    }

    @When("user click Log in")
    public void clickLoginLink() {
        loginPage.openLoginModal();
    }

    @When("user input {string} as username on app")
    public void inputUsername(String username) {
        loginPage.setUsername(username);
    }

    @When("user input {string} as password")
    public void inputPassword(String password) {
        loginPage.setPassword(password);
    }

    @Then("user will redirect to home page")
    public void verifyLoginSuccess() {
        loginPage.clickLogin();
        try {
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isLoginSuccessful());
        } catch (Exception e) {
            Assert.fail("Login failed or took too long.");
        } finally {
            driver.quit();
        }
    }

    @Then("system show message {string}")
    public void verifyLoginError(String expectedMessage) {
        loginPage.clickLogin();
        try {
            Alert alert = driver.switchTo().alert();
            String actualMessage = alert.getText();
            Assert.assertEquals(expectedMessage, actualMessage);
            alert.accept();
        } finally {
            driver.quit();
        }
    }
}

