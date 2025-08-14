package pages.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.pageFactory.CreateAccountPage;

import java.util.HashMap;

public class AndriodCreateAccountPage extends CreateAccountPage {
    public AndriodCreateAccountPage(AppiumDriver driver) {
        super(driver);
    }


    public boolean isNotNowButtonDisplayed() {
        return idDisplayed(notnow);
    }

    @Override
    public void fillForm(HashMap<String, String> formMap) {

        waitAndSendKeys(FirstNametxtbox,formMap.get("name"));
        waitAndSendKeys(emailtxtbox,formMap.get("phone"));
        waitAndSendKeys(passwordtxtbox,formMap.get("password"));
        waitAndClick(this.verifyBtn);
        waitAndClick(this.notnow);
    }

    By FirstNametxtbox = By.id("ap_customer_name");
    By emailtxtbox = By.id("ap_email");
    By passwordtxtbox = By.id("ap_password");
    By verifyBtn = By.id("continue");
    By notnow  = By.id("android:id/autofill_save_no");

}
