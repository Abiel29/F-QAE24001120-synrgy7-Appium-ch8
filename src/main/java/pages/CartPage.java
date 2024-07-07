package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By addToCartButton(String itemName) {
        return AppiumBy.xpath("//android.widget.TextView[@text='" + itemName + "']/following-sibling::android.widget.TextView[@content-desc='test-ADD TO CART']");
    }

    By cartButton = AppiumBy.accessibilityId("test-Cart");
    By checkoutButton = AppiumBy.accessibilityId("test-CHECKOUT");
    By firstNameField = AppiumBy.accessibilityId("test-First Name");
    By lastNameField = AppiumBy.accessibilityId("test-Last Name");
    By postalCodeField = AppiumBy.accessibilityId("test-Zip/Postal Code");
    By continueButton = AppiumBy.accessibilityId("test-CONTINUE");
    By finishButton = AppiumBy.accessibilityId("test-FINISH");
    By successMessage = AppiumBy.xpath("//android.widget.TextView[@text='THANK YOU FOR YOUR ORDER']");

    public void addItemToCart(String itemName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton(itemName))).click();
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys("Jamal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys("Test");
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).sendKeys("12345");
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton)).click();
    }

    public void verifySuccessCheckoutPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}
