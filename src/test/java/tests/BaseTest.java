package tests;

import driverManagement.BaseDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.pageFactory.PageFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class BaseTest extends BaseDriver {

    protected AppiumDriver driver;
    protected static Properties appProperites;
    protected static PageFactory pageFactory;

    @BeforeSuite
    public void init(){
        initAppiumService();
        appProperites = getApplicationProperties();
    }

    @AfterSuite
    public void tearDownService(){
        appiumTearDownService();
    }

    @BeforeMethod
    public void initialize() throws Exception {
        driver = initDriver();
        pageFactory = PageFactory.getPageFactory(driver,properties.getProperty("platform"));
    }

    @AfterMethod
    public void teardown(){
        quitDriver();
    }
}
