package pages.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.pageFactory.ProfileLoggedOutPage;

public class AndriodProfileLoggedOutPage extends ProfileLoggedOutPage {
    public AndriodProfileLoggedOutPage(AppiumDriver driver) {
        super(driver);
    }

    By createAccountBtnId = AppiumBy.accessibilityId("cab");

    public AndriodCreateAccountPage goToCreateAccount() {
        waitAndClick(createAccountBtnId);
        return new AndriodCreateAccountPage(driver);
    }

}
