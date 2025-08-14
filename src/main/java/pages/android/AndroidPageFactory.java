package pages.android;

import io.appium.java_client.AppiumDriver;
import pages.pageFactory.HomePage;
import pages.pageFactory.PageFactory;

public class AndroidPageFactory extends PageFactory {

    AppiumDriver driver;

    public AndroidPageFactory(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }


    @Override
    public HomePage getLaunchPage() {
        return new AndroidHomePage(driver);
    }
}
