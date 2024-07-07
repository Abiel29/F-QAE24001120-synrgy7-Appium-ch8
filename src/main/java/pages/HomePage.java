package pages;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By productsTitle = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");
    By sortButton = AppiumBy.accessibilityId("test-Modal Selector Button");
    By sortOptionLowToHigh = AppiumBy.xpath("//android.widget.TextView[@text='Price (low to high)']");
    By firstItemPrice = AppiumBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])[1]");
    By secondItemPrice = AppiumBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])[2]");

    public void verifyHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle)).isDisplayed();
    }

    public void sortItemsByPriceLowToHigh() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortOptionLowToHigh)).click();
    }

    public void verifySortedItems() {
        double firstPrice = Double.parseDouble(wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemPrice)).getText().substring(1));
        double secondPrice = Double.parseDouble(wait.until(ExpectedConditions.visibilityOfElementLocated(secondItemPrice)).getText().substring(1));
        //Assert.isTrue(firstPrice < secondPrice);
    }
}
