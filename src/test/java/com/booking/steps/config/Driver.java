package com.booking.steps.config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

   public static AndroidDriver androidDriver = setAndroidDriver();

    public static AndroidDriver setAndroidDriver() {
        AndroidDriver driver = null;
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("platformVersion", "14");
            capabilities.setCapability("deviceName", "Phone");
            capabilities.setCapability("appPackage", "com.booking");
            capabilities.setCapability("appActivity", "com.booking.startup.HomeActivity");

            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;

    }
}