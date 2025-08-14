package pages.baseclasses;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;

    public static final int SHORT_WAIT=30;
    WebDriverWait webDriverWait;

    public BasePage(AppiumDriver driver){
        this.driver=driver;
        webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(SHORT_WAIT));
    }

    public void waitAndClick(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitAndSendKeys(By locator, String text){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public boolean idDisplayed(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
}
