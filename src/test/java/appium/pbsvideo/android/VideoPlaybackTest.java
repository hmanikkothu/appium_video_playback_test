package appium.pbsvideo.android;

import appium.pbsvideo.android.util.SlingTVTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;

import java.util.List;

import static appium.pbsvideo.android.util.Helpers.*;

/**
 * Created by hmanikkothu on 2/21/2017.
 */
public class VideoPlaybackTest extends SlingTVTest {

    @Test
    public void playbackLocalNowVideo() throws  Exception {

        WebElement el;

        clickIfExists(By.id("android:id/button2"));
        clickIfExists(By.id("com.sling:id/signin_button"));
        slingTvLogin();
        clickIfExists(By.id("com.android.packageinstaller:id/permission_deny_button"));
        clickIfExists(By.id("com.sling:id/toolbar_menu_button"));
        if (driver.getOrientation() == ScreenOrientation.LANDSCAPE) {
            System.out.println("ScreenOrientation.LANDSCAPE !! ");
            el = driver.findElementById("com.sling:id/menu_list");
            //Point location = el.getLocation();
            List<WebElement> list = driver.findElementsByClassName("android.widget.LinearLayout");
            TouchAction swipe = new TouchAction(driver).press(list.get(3), 0, 500).waitAction(1000).moveTo(list.get(1), 0, 100).release();
            swipe.perform();
        }
        clickIfExists(By.id("com.sling:id/search"));
        sendKeys(By.id("android:id/search_src_text"), "Local Now");
        sendKeys(AndroidKeyCode.ENTER);
        clickIfExists(for_text("Local Now"));
        clickIfExists(By.id("com.sling:id/details_start_live_button"));


        Thread.sleep(20000);

    }
}
