package appium.pbsvideo.android.util;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static appium.pbsvideo.android.util.Helpers.*;


//        Sling TV app version 5.1.577

/**
 * Created by hmanikkothu on 2/21/2017.
 */
public class SlingTVTest {

    /** Run before each test **/
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("appium-version", "1.1.0");
        capabilities.setCapability("deviceName","SAMSUNG-SM-G930V");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.sling");
        capabilities.setCapability("appActivity", "com.movenetworks.MainActivity");
        capabilities.setCapability("clearSystemFiles", "true");

        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(serverAddress, capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Helpers.init(driver, serverAddress);
    }

    /** Run after each test **/
    @After
    public void tearDown() throws Exception {
        if (driver != null) driver.quit();
    }

    public void slingTvLogin() {

        sendKeys(By.id("com.sling:id/username"), "******.*****@*****.com");
        sendKeys(By.id("com.sling:id/password"), "****......**");
        clickIfExists(By.id("com.sling:id/toggling_text"));

    }
}
