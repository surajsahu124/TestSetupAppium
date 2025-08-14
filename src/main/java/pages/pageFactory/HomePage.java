package pages.pageFactory;

import io.appium.java_client.AppiumDriver;
import pages.baseclasses.BasePage;

public abstract class HomePage extends BasePage {

     public HomePage(AppiumDriver driver){
         super(driver);
     }

     public void skipPopupsIfAny(){}
    public abstract void searchForProduct(String keyword);
    public abstract boolean isAutoCompleteListDisplayed();
    public abstract void skipSignAndDismiss();
    public abstract ProfileLoggedOutPage goToUserProfile();
}
