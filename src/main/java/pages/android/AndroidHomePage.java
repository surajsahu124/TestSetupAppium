package pages.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.pageFactory.HomePage;
import pages.pageFactory.ProfileLoggedOutPage;

public class AndroidHomePage extends HomePage {
    public AndroidHomePage(AppiumDriver driver) {
        super(driver);
    }


    By skipSignInBtnId = By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button");
    By dismissBtnId = By.id("com.amazon.mShop.android.shopping:id/left_button");
    By searchHintBarId = By.id("com.amazon.mShop.android.shopping:id/chrome_search_hint_view");
    By searchBarTxtId = By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text");
    By autocompleteListId = By.id("com.amazon.mShop.android.shopping:id/mash_web_fragment");

    By bottomNavigationId = By.id("(//android.widget.ImageView[@resource-id=\"com.amazon.mShop.android.shopping:id/bottom_tab_button_icon\"])[2]");

    By navid = AppiumBy.accessibilityId("Your Amazon.com Tab 2 of 4");



    @Override
    public void searchForProduct(String keyword) {
        waitAndClick(searchHintBarId);
        waitAndSendKeys(searchBarTxtId, keyword);

    }

    @Override
    public boolean isAutoCompleteListDisplayed() {
        return idDisplayed(autocompleteListId);
    }

    @Override
    public void skipSignAndDismiss() {
        waitAndClick(skipSignInBtnId);
        waitAndClick(dismissBtnId);
    }



    public ProfileLoggedOutPage goToUserProfile() {
        waitAndClick(navid);
        return new AndriodProfileLoggedOutPage(this.driver);
    }
}
