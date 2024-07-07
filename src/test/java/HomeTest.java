import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest {
    private AndroidDriver driver;
    private HomePage homepage;

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
        homepage = new HomePage(driver);
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSortItemsByPriceLowToHigh() {
        homepage.verifyHomePage();
        homepage.sortItemsByPriceLowToHigh();
        homepage.verifySortedItems();
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
        homepage = new HomePage(driver);
    }

    @When("I sort items by price from low to high")
    public void i_sort_items_by_price_from_low_to_high() {
        homepage.sortItemsByPriceLowToHigh();
    }

    @Then("the first item should be cheaper than the second item")
    public void the_first_item_should_be_cheaper_than_the_second_item() {
        homepage.verifySortedItems();
        driver.quit();
    }

}
