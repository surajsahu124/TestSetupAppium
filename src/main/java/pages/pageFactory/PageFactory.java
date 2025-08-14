package pages.pageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pages.android.AndroidPageFactory;
import pages.ios.IOSPageFactory;

public abstract class PageFactory {



    AppiumDriver driver;

    public PageFactory(AppiumDriver driver) {
        this.driver = driver;
    }

    public static PageFactory getPageFactory(AppiumDriver driver,String platform){
        return switch (platform){
            case "android" -> new AndroidPageFactory(driver);
            case "ios" -> new IOSPageFactory(driver);
            default -> throw new IllegalArgumentException("Platform"+platform+"is not correct value");
        };
    }

    public abstract HomePage getLaunchPage();

}
