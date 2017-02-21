package com.example.android.testing.espresso.BasicSample;

import com.mobileenerlytics.eagle.tester.appium.EagleTester;
import com.mobileenerlytics.eagle.tester.common.EagleTesterArgument;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.InterruptedIOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Created by ankita on 3/2/17.
 */
public class EnergyConsumptionEleven {

    public AndroidDriver dr;
    //EagleTester eagleTester;


    @Before
    public void setup() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.VERSION, "4.4.2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Windows");
        capabilities.setCapability("deviceName", "0123456789ABCDEF");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appPackage", "launcher3.android.com.hivelauncher");
        capabilities.setCapability("appActivity", "com.android.launcher3.Launcher");
        dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        dr.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

//        EagleTesterArgument eagleTesterArgument = new EagleTesterArgument();
//        eagleTesterArgument.setArguments(EagleTesterArgument.PACKAGE_NAME, "launcher3.android.com.hivelauncher");
//        eagleTester = new EagleTester(dr, eagleTesterArgument);
    }

    @Test
    public void CurrentConsumption() throws InterruptedException {
        //eagleTester.startMeasure();

        dr.findElementById("launcher3.android.com.hivelauncher:id/cling_dismiss_longpress_info").click();

        dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
        dr.swipe(75,459,411,516,0);
        //Thread.sleep(2000);
        dr.findElementById("launcher3.android.com.hivelauncher:id/user_interest_feed_recycler");
        Dimension dp = dr.manage().window().getSize();
        int height = dp.getHeight();
        int width = dp.getWidth();
        int starty = (int) (dp.height * 0.80);
        int endy = (int) (dp.height * 0.20);
        int startx = dp.width / 2;
        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        dr.findElementById("launcher3.android.com.hivelauncher:id/category_swap_button").click();
        dr.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().text(\"World Stories\"))").click();
        dr.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().text(\"Entertainment\"))").click();
        dr.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().text(\"Sports\"))").click();
        dr.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().text(\"Life Style\"))").click();
        dr.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().text(\"Videos\"))").click();

        dr.findElementById("launcher3.android.com.hivelauncher:id/category_selection_completion_btn").click();

        //Thread.sleep(3000);
        for(int i=0;i<50;i++)
            if(i<25)
                dr.swipe(startx,starty,startx,endy,2000);// swipping page after unmarking categories
        else
                dr.swipe(startx,endy,startx,starty,2000);
        //Thread.sleep(1000);
        //eagleTester.stopMeasure();

//        //Swipe from top to bottom
//        dr.swipe(startx,endy,startx,starty,2000);
//        Thread.sleep(1000);
    }


    @After
    public void quit() throws Exception {
        if (dr != null) {
            dr.quit();
            //eagleTester.finish();

        }
    }
}
