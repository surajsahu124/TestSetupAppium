package pages.pageFactory;

import io.appium.java_client.AppiumDriver;
import pages.baseclasses.BasePage;

public abstract class  ProfileLoggedOutPage extends BasePage {
    public ProfileLoggedOutPage(AppiumDriver driver) {
        super(driver);
    }

    public abstract CreateAccountPage goToCreateAccount();
}
