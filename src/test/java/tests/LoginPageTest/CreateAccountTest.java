package tests.LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pageFactory.CreateAccountPage;
import pages.pageFactory.HomePage;
import pages.pageFactory.ProfileLoggedOutPage;
import tests.BaseTest;

import java.util.HashMap;

public class CreateAccountTest extends BaseTest {

    @Test
    public void testRegisterUserForm(){


        HomePage homePage = pageFactory.getLaunchPage();
        homePage.skipSignAndDismiss();
        ProfileLoggedOutPage profileLoggedOutPage = homePage.goToUserProfile();
        CreateAccountPage createAccountPage = profileLoggedOutPage.goToCreateAccount();

        HashMap<String,String> formMap=new HashMap<>();
        formMap.put("name","Raaj");
        formMap.put("email","123newemail12@gmail.com");
        formMap.put("password","R4aj@pas");

       //createAccountPage.fillForm(formMap);
        //Assert.assertTrue(createAccountPage.isNotNowButtonDisplayed());

    }
}
