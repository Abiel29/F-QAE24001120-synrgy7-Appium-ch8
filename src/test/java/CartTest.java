import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartTest {
    private AndroidDriver driver;
    private CartPage cartPage;

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
        cartPage = new CartPage(driver);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCheckout() {
        cartPage.addItemToCart("Sauce Labs Backpack");
        cartPage.addItemToCart("Sauce Labs Bike Light");
        cartPage.proceedToCheckout();
        cartPage.verifySuccessCheckoutPage();
    }

    @Given("On Home Page")
    public void on_home_page() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "/mnt/data/[Exercise CH 8] Android.SauceLabs.Mobile.Sample.app.2.7.1 (1).apk");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        driver = new AndroidDriver(capabilities);
        cartPage = new CartPage(driver);
    }
    @When("I add two different items to the cart")
    public void i_add_two_different_items_to_the_cart() {
        cartPage.addItemToCart("Sauce Labs Backpack");
        cartPage.addItemToCart("Sauce Labs Bike Light");
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        cartPage.proceedToCheckout();
    }

    @Then("I should see the success checkout page")
    public void i_should_see_the_success_checkout_page() {
        cartPage.verifySuccessCheckoutPage();
        driver.quit();
    }
}
