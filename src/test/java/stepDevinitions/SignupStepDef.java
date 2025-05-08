package stepDevinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignupPage;

public class SignupStepDef {
    WebDriver driver = new ChromeDriver();
    SignupPage signupPage = new SignupPage(driver);

    @Given("user on the home page")
    public void userOnHomePage() {
        driver.get("https://demoblaze.com/");
    }

    @When("user click Sign up")
    public void userClickSignUp() {
        signupPage.clickSignUpLink();
    }

    @When("user input username {string}")
    public void userInputUsername(String username) {
        signupPage.enterUsername(username);
    }

    @When("user input password {string}")
    public void userInputPassword(String password) {
        signupPage.enterPassword(password);
    }

    @When("user click Sign Up")
    public void userClickSignUpButton() {
        signupPage.clickSignUpButton();
    }

    @Then("user show message {string}")
    public void userShowMessage(String expectedMessage) {
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        alert.accept();
        driver.quit();
    }
}


