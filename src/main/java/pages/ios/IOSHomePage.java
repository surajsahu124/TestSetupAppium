package pages.ios;

import io.appium.java_client.AppiumDriver;
import pages.pageFactory.HomePage;

public abstract class IOSHomePage extends HomePage {
    public IOSHomePage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void searchForProduct(String keyword) {

    }

    @Override
    public boolean isAutoCompleteListDisplayed() {
        return false;
    }

    @Override
    public void skipSignAndDismiss() {

    }
}
