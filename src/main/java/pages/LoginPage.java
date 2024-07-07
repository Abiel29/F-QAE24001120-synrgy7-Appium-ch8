package pages;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    AndroidDriver driver;
    WebDriverWait wait;

    public LoginPage (AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By usernameField = AppiumBy.accessibilityId("test-Username");
    By passwordField = AppiumBy.accessibilityId("test-Password");
    By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    By productsTitle = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");
    By errorMessage = AppiumBy.xpath("//android.widget.TextView[@text='Username and password do not match any user in this service']");

    public void inputUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }

    public void inputPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clicklLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }

    public void verifyHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle)).isDisplayed();
    }

    public void verifyErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
    }
}