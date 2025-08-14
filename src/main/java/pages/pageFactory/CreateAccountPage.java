package pages.pageFactory;

import io.appium.java_client.AppiumDriver;
import pages.baseclasses.BasePage;

import java.util.HashMap;

public abstract class CreateAccountPage extends BasePage {
    public CreateAccountPage(AppiumDriver driver) {
        super(driver);
    }

    public abstract void fillForm(HashMap<String, String> formMap);
    public abstract boolean isNotNowButtonDisplayed();
}
