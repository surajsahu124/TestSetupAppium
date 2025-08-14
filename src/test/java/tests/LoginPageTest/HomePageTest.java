package tests.LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pageFactory.HomePage;
import tests.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    public void validateHomePageTitleAndLogo(){
        HomePage homePage = pageFactory.getLaunchPage();
        homePage.skipSignAndDismiss();
        homePage.searchForProduct("neck band");
        Assert.assertTrue(homePage.isAutoCompleteListDisplayed());
    }


}
