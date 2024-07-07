import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    private AndroidDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "/mnt/data/[Exercise CH 8] Android.SauceLabs.Mobile.Sample.app.2.7.1 (1).apk");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");


        driver = new AndroidDriver(capabilities);
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clicklLoginButton();
        loginPage.verifyHomePage();
    }

    @Test
    public void testFailedLogin() {
        loginPage.inputUsername("invalid_user");
        loginPage.inputPassword("invalid_password");
        loginPage.clicklLoginButton();
        loginPage.verifyErrorMessage();
    }

    @Given("On The Login Page")
    public void on_the_loginpage() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "/mnt/data/[Exercise CH 8] Android.SauceLabs.Mobile.Sample.app.2.7.1 (1).apk");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        driver = new AndroidDriver(capabilities);
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
    }

    @When("I enter invalid credentials")
    public void i_enter_invalid_credentials() {
        loginPage.inputUsername("invalid_user");
        loginPage.inputPassword("invalid_password");
    }

    @When("I press login")
    public void i_press_login() {
        loginPage.clicklLoginButton();
    }

    @Then("I should see the homepage")
    public void i_should_see_the_homepage() {
        loginPage.verifyHomePage();
        driver.quit();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        loginPage.verifyErrorMessage();
        driver.quit();
    }

}
