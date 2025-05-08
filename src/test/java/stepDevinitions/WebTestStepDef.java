package stepDevinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.WebTestPage;

public class WebTestStepDef {
    WebDriver driver = new ChromeDriver();
    WebTestPage webTestPage = new WebTestPage(driver);

    @Given("user open website Demoblaze")
    public void openDemoblazeWebsite() {
        webTestPage.openWebsite();
        Assert.assertTrue("Website tidak terbuka dengan benar", webTestPage.isWebsiteLoaded());
        driver.quit();
    }
}
