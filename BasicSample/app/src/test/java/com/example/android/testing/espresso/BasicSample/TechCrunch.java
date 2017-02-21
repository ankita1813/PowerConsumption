package com.example.android.testing.espresso.BasicSample;


import com.mobileenerlytics.eagle.tester.appium.EagleTester;
import com.mobileenerlytics.eagle.tester.common.EagleTesterArgument;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Created by ankita on 10/2/17.
 */
public class TechCrunch {

    public AndroidDriver dr;
    EagleTester eagleTester;


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

        EagleTesterArgument eagleTesterArgument = new EagleTesterArgument();
        eagleTesterArgument.setArguments(EagleTesterArgument.PACKAGE_NAME, "launcher3.android.com.hivelauncher");
        eagleTester = new EagleTester(dr, eagleTesterArgument);
    }

    @Test()
    public void SearchAnApp() throws InterruptedException {
        eagleTester.startMeasure();

        //long startTime= System.currentTimeMillis();

        dr.findElementById("launcher3.android.com.hivelauncher:id/cling_dismiss_longpress_info").click();

        dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
        Thread.sleep(2000);
        dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        System.out.println("First permission has been given");
        dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        System.out.println("Second Permission Given");
        dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        System.out.println("Third Permission Given");
        dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        System.out.println("Fourth Permission Given");
        dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        System.out.println("Fifth Permission Given");
        dr.findElementById("launcher3.android.com.hivelauncher:id/cling_dismiss_ramcleaner_info").click();
        Thread.sleep(1000);
        dr.findElementById("launcher3.android.com.hivelauncher:id/et_search").sendKeys("TechCrunch");
        dr.findElementByXPath("//android.widget.TextView[@index='0']").click();
        Thread.sleep(2000);
        dr.findElementById("com.aol.mobile.techcrunch:id/feed_list_row_container");
        Dimension dp = dr.manage().window().getSize();
        int height = dp.getHeight();
        int width = dp.getWidth();
        int starty = (int) (dp.height * 0.80);
        int endy = (int) (dp.height * 0.20);
        int startx = dp.width / 2;
        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        for (int i = 0; i < 50; i++)
            if (i < 25)
                dr.swipe(startx, starty, startx, endy, 2000);
            else
                dr.swipe(startx, endy, startx, starty, 2000);
        Thread.sleep(200);
        eagleTester.stopMeasure();

    }

    @After
    public void quit() throws Exception {
        if (dr != null) {
            dr.quit();
            eagleTester.finish();

        }


    }
}



