package pages.ios;

import io.appium.java_client.AppiumDriver;
import pages.pageFactory.HomePage;
import pages.pageFactory.PageFactory;
import pages.pageFactory.ProfileLoggedOutPage;

public class IOSPageFactory extends PageFactory {


    AppiumDriver driver;

    public IOSPageFactory(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public HomePage getLaunchPage() {
        return null;
    }


}
