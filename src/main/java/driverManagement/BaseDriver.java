package driverManagement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseDriver {


    AppiumDriverLocalService appiumServiceBuilder;
    AppiumDriver driver;

    static String APPIUM_SERVER="http://127.0.0.1:4723";
    static String ANDRIOD = "android";
    static String IOS="ios";
    protected static Properties properties = new Properties();

    public Properties getApplicationProperties(){
        return properties;
    }


    public AppiumDriver initDriver() throws IOException {
        loadPropertyFile();
        if(properties.get("platform").equals(ANDRIOD)){
            driver = new AndroidDriver(URI.create(APPIUM_SERVER).toURL(),getDesiredCapabilities(ANDRIOD));
        } else if (properties.get("platform").equals(IOS)) {
            driver = new IOSDriver(URI.create(APPIUM_SERVER).toURL(),getDesiredCapabilities(IOS));
        }
        else{
            throw new IllegalArgumentException("Platform Name"+ properties.get("platform")+" is not valid");
        }
        return driver;
    }
    
    
    public void loadPropertyFile() throws IOException {
        InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/application.properties");
        properties.load(inputStream);
    }


    private static DesiredCapabilities getDesiredCapabilities(String platform){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion",properties.getProperty("platformVersion"));


        if (platform.equals(ANDRIOD)) {
            capabilities.setCapability("platformName", "android");
            //capabilities.setCapability("appium:platformVersion","16.0");
            capabilities.setCapability( "appium:automationName", "uiautomator2");
            capabilities.setCapability( "app", System.getProperty("user.dir")+"/src/main/resources/app/com-amazon-mshop-android-shopping.apk");
            capabilities.setCapability("newCommandTimeout",120);
            capabilities.setCapability("autoGrantPermissions", true);
            // Use only if Appium fails to detect these automatically
            capabilities.setCapability("appium:appPackage", "com.amazon.mShop.android.shopping");
            capabilities.setCapability("appium:appActivity", "com.amazon.mShop.home.HomeActivity"); // Replace if needed
        } else if (platform.equals(IOS)) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability( "appium:automationName", "xcuitest");
            capabilities.setCapability( "udid", "7A98D98F-5B96-4AEA-BF47-C4852AB33122");
            capabilities.setCapability( "bundleId", "com.amazon.Amazon");
        }
        else{
            throw new IllegalArgumentException("Platform Name"+platform+" is not valid");
        }

        return capabilities;

    }

    /*public AndroidDriver initAndroidDriver() throws MalformedURLException {
        driver = new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(),getDesiredCapabilities());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }*/

    public void quitDriver(){
        driver.quit();

    }

    public void appiumTearDownService(){
        appiumServiceBuilder.stop();
    }

    public void initAppiumService(){
        appiumServiceBuilder = AppiumDriverLocalService.buildService(
                 new AppiumServiceBuilder()
                       //  .usingDriverExecutable()
                        // .withAppiumJS()
                         .withLogFile(new File(System.getProperty("user.dir")+"/target/appiumServiceLogs.txt"))
                         .withArgument(GeneralServerFlag.LOCAL_TIMEZONE));

        appiumServiceBuilder.start();
    }

}
